package com.mz.example.service.long_id;

import com.mz.example.db.long_id.entity.*;
import com.mz.example.db.long_id.repository.*;
import com.mz.example.service.BasePerformanceTestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class LongIdPerformanceTestingService extends BasePerformanceTestingService{

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

    private static long ID = 0;

    @Transactional
    public void performanceTest(int packageSize){
        if(packageSize < 0 || packageSize > MAX_PACKAGE_SIZE){
            throw new IllegalArgumentException("Invalid package size: "+packageSize);
        }
        ArrayList<PrimaryTableL> primaryTableLS = new ArrayList<>();
        ArrayList<NestedTable1L> nestedTable1LS = new ArrayList<>();
        ArrayList<NestedTable2L> nestedTable2LS = new ArrayList<>();
        ArrayList<NestedTable3L> nestedTable3LS = new ArrayList<>();
        ArrayList<NestedTable4L> nestedTable4LS = new ArrayList<>();
        for(int i = 0; i < packageSize; ++i){
            PrimaryTableL primaryTable = fillWithDataInternal(new PrimaryTableL());
            NestedTable1L nestedTable1 = fillWithDataInternal(new NestedTable1L());
            NestedTable2L nestedTable2 = fillWithDataInternal(new NestedTable2L());
            NestedTable3L nestedTable3 = fillWithDataInternal(new NestedTable3L());
            NestedTable4L nestedTable4 = fillWithDataInternal(new NestedTable4L());

            ++ID;

            primaryTableLS.add(primaryTable);
            nestedTable1LS.add(nestedTable1);
            nestedTable2LS.add(nestedTable2);
            nestedTable3LS.add(nestedTable3);
            nestedTable4LS.add(nestedTable4);
//            primaryTableLRepository.save(primaryTable);
//            nestedTable1LRepository.save(nestedTable1);
//            nestedTable2LRepository.save(nestedTable2);
//            nestedTable3LRepository.save(nestedTable3);
//            nestedTable4LRepository.save(nestedTable4);
        }
        primaryTableLRepository.saveAll(primaryTableLS);
        nestedTable1LRepository.saveAll(nestedTable1LS);
        nestedTable2LRepository.saveAll(nestedTable2LS);
        nestedTable3LRepository.saveAll(nestedTable3LS);
        nestedTable4LRepository.saveAll(nestedTable4LS);
    }

    private <ENTITY extends LongBaseEntity> ENTITY fillWithDataInternal(ENTITY input){
        input = fillWithData(input);
        input.setId(ID);
        return input;
    }
}
