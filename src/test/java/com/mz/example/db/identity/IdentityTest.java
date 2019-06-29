package com.mz.example.db.identity;

import com.mz.example.db.identity.entity.IdentityBaseEntity;
import com.mz.example.db.identity.repository.*;
import com.mz.example.service.identity.IdentityPerformanceTestingService;
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
public class IdentityTest {

    @Autowired
    private IdentityPerformanceTestingService identityPerformanceTestingService;

    @Autowired
    private PrimaryTableRepository primaryTableRepository;
    @Autowired
    private NestedTable1Repository nestedTable1Repository;
    @Autowired
    private NestedTable2Repository nestedTable2Repository;
    @Autowired
    private NestedTable3Repository nestedTable3Repository;
    @Autowired
    private NestedTable4Repository nestedTable4Repository;

    @Test
    public void testSave() throws Exception{
        identityPerformanceTestingService.performanceTest(1);

//        Thread.sleep(1000*60*5);

        Assert.assertTrue(primaryTableRepository.findById(1L).isPresent());//This works
        assertTableContent(primaryTableRepository);//Why this fails?
        assertTableContent(nestedTable1Repository);
        assertTableContent(nestedTable2Repository);
        assertTableContent(nestedTable3Repository);
        assertTableContent(nestedTable4Repository);
    }

    private void assertTableContent(CrudRepository<? extends IdentityBaseEntity, Long> repository){
        Assert.assertEquals(1, repository.count());
        Optional<? extends IdentityBaseEntity> savedValue = repository.findById(1L);
        Assert.assertTrue(savedValue.isPresent());
        Assert.assertEquals(Long.valueOf(1L), savedValue.get().getId());
    }
}
