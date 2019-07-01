package com.mz.example.db.long_id;

import com.mz.example.db.long_id.entity.LongBaseEntity;
import com.mz.example.db.long_id.repository.*;
import com.mz.example.service.long_id.LongIdPerformanceTestingService;
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
public class LongIdTest {

    @Autowired
    private LongIdPerformanceTestingService longIdPerformanceTestingService;

    @Autowired
    private PrimaryTableLRepository primaryTableLRepository;
    @Autowired
    private NestedTable1LRepository nestedTable1LRepository;
    @Autowired
    private NestedTable2LRepository nestedTable2LRepository;
    @Autowired
    private NestedTable3LRepository nestedTable3LRepository;
    @Autowired
    private NestedTable4LRepository nestedTable4LRepository;

    @Test
    public void testSave() throws Exception{
        longIdPerformanceTestingService.performanceTest(1);

        assertTableContent(primaryTableLRepository);
        assertTableContent(nestedTable1LRepository);
        assertTableContent(nestedTable2LRepository);
        assertTableContent(nestedTable3LRepository);
        assertTableContent(nestedTable4LRepository);
    }

    private void assertTableContent(CrudRepository<? extends LongBaseEntity, Long> repository){
        Assert.assertEquals(1, repository.count());
        Optional<? extends LongBaseEntity> savedValue = repository.findById(0L);
        Assert.assertTrue(savedValue.isPresent());
        Assert.assertEquals(Long.valueOf(0L), savedValue.get().getId());
    }
}
