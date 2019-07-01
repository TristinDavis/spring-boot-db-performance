package com.mz.example.db.one_to_one;

import com.mz.example.db.one_to_one.entity.OneToOneBaseEntity;
import com.mz.example.db.one_to_one.entity.PrimaryTableO;
import com.mz.example.db.one_to_one.repository.*;
import com.mz.example.service.one_to_one.OneToOnePerformanceTestingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:test.properties")
public class OneToOneTest {

    @Autowired
    private OneToOnePerformanceTestingService oneToOnePerformanceTestingService;

    @Autowired
    private PrimaryTableORepository primaryTableORepository;
    @Autowired
    private NestedTable1ORepository nestedTable1ORepository;
    @Autowired
    private NestedTable2ORepository nestedTable2ORepository;
    @Autowired
    private NestedTable3ORepository nestedTable3ORepository;
    @Autowired
    private NestedTable4ORepository nestedTable4ORepository;

    @Test
    public void testSave() throws Exception{
        oneToOnePerformanceTestingService.performanceTest(1);

        assertTableContent(primaryTableORepository);
        assertTableContent(nestedTable1ORepository);
        assertTableContent(nestedTable2ORepository);
        assertTableContent(nestedTable3ORepository);
        assertTableContent(nestedTable4ORepository);

        Optional<PrimaryTableO> savedValue = primaryTableORepository.findById(0L);
        Assert.assertTrue(savedValue.isPresent());
        Assert.assertNotNull(savedValue.get().getNestedTable1());
        Assert.assertEquals(savedValue.get().getId(), savedValue.get().getNestedTable1().getId());
        Assert.assertNotNull(savedValue.get().getNestedTable2());
        Assert.assertEquals(savedValue.get().getId(), savedValue.get().getNestedTable2().getId());
        Assert.assertNotNull(savedValue.get().getNestedTable3());
        Assert.assertEquals(savedValue.get().getId(), savedValue.get().getNestedTable3().getId());
        Assert.assertNotNull(savedValue.get().getNestedTable4());
        Assert.assertEquals(savedValue.get().getId(), savedValue.get().getNestedTable4().getId());
    }

    private void assertTableContent(CrudRepository<? extends OneToOneBaseEntity, Long> repository){
        Assert.assertEquals(1, repository.count());
        Optional<? extends OneToOneBaseEntity> savedValue = repository.findById(0L);
        Assert.assertTrue(savedValue.isPresent());
        Assert.assertEquals(Long.valueOf(0L), savedValue.get().getId());
    }
}
