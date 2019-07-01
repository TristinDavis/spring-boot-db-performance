package com.mz.example.service.identity;

import com.mz.example.db.identity.entity.*;
import com.mz.example.db.identity.repository.*;
import com.mz.example.service.BasePerformanceTestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//TODO: Service vs Component?
@Service
public class IdentityPerformanceTestingService extends BasePerformanceTestingService{

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

    @Transactional
    public void performanceTest(int packageSize){
        if(packageSize < 0 || packageSize > MAX_PACKAGE_SIZE){
            throw new IllegalArgumentException("Invalid package size: "+packageSize);
        }
        for(int i = 0; i < packageSize; ++i){
            PrimaryTableI primaryTable = fillWithData(new PrimaryTableI());
            NestedTable1I nestedTable1 = fillWithData(new NestedTable1I());
            NestedTable2I nestedTable2 = fillWithData(new NestedTable2I());
            NestedTable3I nestedTable3 = fillWithData(new NestedTable3I());
            NestedTable4I nestedTable4 = fillWithData(new NestedTable4I());

            primaryTableIRepository.save(primaryTable);
            nestedTable1IRepository.save(nestedTable1);
            nestedTable2IRepository.save(nestedTable2);
            nestedTable3IRepository.save(nestedTable3);
            nestedTable4IRepository.save(nestedTable4);
        }
    }
}
