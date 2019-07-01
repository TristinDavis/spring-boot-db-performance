package com.mz.example.service.no_id;

import com.mz.example.db.no_id.entity.*;
import com.mz.example.db.no_id.repository.*;
import com.mz.example.service.BasePerformanceTestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoIdPerformanceTestingService extends BasePerformanceTestingService {

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

    private static long ID = 0;

    @Override
    @Transactional
    public void performanceTest(int packageSize) {
        if(packageSize < 0 || packageSize > MAX_PACKAGE_SIZE){
            throw new IllegalArgumentException("Invalid package size: "+packageSize);
        }
        for(int i = 0; i < packageSize; ++i){
            PrimaryTableN primaryTable = fillWithDataInternal(new PrimaryTableN());
            NestedTable1N nestedTable1 = fillWithDataInternal(new NestedTable1N());
            NestedTable2N nestedTable2 = fillWithDataInternal(new NestedTable2N());
            NestedTable3N nestedTable3 = fillWithDataInternal(new NestedTable3N());
            NestedTable4N nestedTable4 = fillWithDataInternal(new NestedTable4N());

            ++ID;

            primaryTableNRepository.save(primaryTable);
            nestedTable1NRepository.save(nestedTable1);
            nestedTable2NRepository.save(nestedTable2);
            nestedTable3NRepository.save(nestedTable3);
            nestedTable4NRepository.save(nestedTable4);
        }
    }

    private <ENTITY extends NoIdBaseEntity> ENTITY fillWithDataInternal(ENTITY input){
        input = fillWithData(input);
        input.setId(ID);
        return input;
    }
}
