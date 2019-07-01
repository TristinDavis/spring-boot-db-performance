package com.mz.example.service.one_to_one;

import com.mz.example.db.one_to_one.entity.*;
import com.mz.example.db.one_to_one.repository.PrimaryTableORepository;
import com.mz.example.service.BasePerformanceTestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OneToOnePerformanceTestingService extends BasePerformanceTestingService {

    @Autowired
    private PrimaryTableORepository primaryTableORepository;

    private static long ID = 0;

    public void performanceTest(int packageSize){
        if(packageSize < 0 || packageSize > MAX_PACKAGE_SIZE){
            throw new IllegalArgumentException("Invalid package size: "+packageSize);
        }
        List<PrimaryTableO> toInsert = new ArrayList<>();
        for(int i = 0; i < packageSize; ++i) {
            PrimaryTableO primaryTable = fillWithDataInternal(new PrimaryTableO());
            NestedTable1O nestedTable1 = fillWithDataInternal(new NestedTable1O());
            NestedTable2O nestedTable2 = fillWithDataInternal(new NestedTable2O());
            NestedTable3O nestedTable3 = fillWithDataInternal(new NestedTable3O());
            NestedTable4O nestedTable4 = fillWithDataInternal(new NestedTable4O());

            primaryTable.setNestedTable1(nestedTable1);
            primaryTable.setNestedTable2(nestedTable2);
            primaryTable.setNestedTable3(nestedTable3);
            primaryTable.setNestedTable4(nestedTable4);

            ++ID;
            toInsert.add(primaryTable);
        }

        primaryTableORepository.saveAll(toInsert);
    }

    private <ENTITY extends OneToOneBaseEntity> ENTITY fillWithDataInternal(ENTITY input){
        input = fillWithData(input);
        input.setId(ID);
        return input;
    }
}
