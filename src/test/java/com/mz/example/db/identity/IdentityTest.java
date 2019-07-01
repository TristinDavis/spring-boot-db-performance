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
    private PrimaryTableIRepository primaryTableIRepository;
    @Autowired
    private NestedTable1IRepository nestedTable1IRepository;
    @Autowired
    private NestedTable2IRepository nestedTable2IRepository;
    @Autowired
    private NestedTable3IRepository nestedTable3IRepository;
    @Autowired
    private NestedTable4IRepository nestedTable4IRepository;

    @Test
    public void testSave() throws Exception{
        identityPerformanceTestingService.performanceTest(1);

        assertTableContent(primaryTableIRepository);
        assertTableContent(nestedTable1IRepository);
        assertTableContent(nestedTable2IRepository);
        assertTableContent(nestedTable3IRepository);
        assertTableContent(nestedTable4IRepository);
    }

    private void assertTableContent(CrudRepository<? extends IdentityBaseEntity, Long> repository){
        Assert.assertEquals(1, repository.count());
        Optional<? extends IdentityBaseEntity> savedValue = repository.findById(1L);
        Assert.assertTrue(savedValue.isPresent());
        Assert.assertEquals(Long.valueOf(1L), savedValue.get().getId());
    }
}
