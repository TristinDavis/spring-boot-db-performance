package com.mz.example.db.no_id;

import com.mz.example.db.no_id.entity.NoIdBaseEntity;
import com.mz.example.db.no_id.repository.*;
import com.mz.example.service.no_id.NoIdPerformanceTestingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:test.properties")
public class NoIdTest {

    @Autowired
    private NoIdPerformanceTestingService noIdPerformanceTestingService;

    @Autowired
    private PrimaryTableNRepository primaryTableNRepository;
    @Autowired
    private NestedTable1NRepository nestedTable1NRepository;
    @Autowired
    private NestedTable2NRepository nestedTable2NRepository;
    @Autowired
    private NestedTable3NRepository nestedTable3NRepository;
    @Autowired
    private NestedTable4NRepository nestedTable4NRepository;

    @Test
    public void testSave() throws Exception{
        noIdPerformanceTestingService.performanceTest(1);

        assertTableContent(primaryTableNRepository);
        assertTableContent(nestedTable1NRepository);
        assertTableContent(nestedTable2NRepository);
        assertTableContent(nestedTable3NRepository);
        assertTableContent(nestedTable4NRepository);
    }

    private void assertTableContent(CrudRepository<? extends NoIdBaseEntity, Long> repository){
        Assert.assertEquals(1, repository.count());
        NoIdBaseEntity savedValue = repository.findAll().iterator().next();
        Assert.assertNotNull(savedValue);
        Assert.assertEquals(Long.valueOf(0L), savedValue.getId());
    }
}
