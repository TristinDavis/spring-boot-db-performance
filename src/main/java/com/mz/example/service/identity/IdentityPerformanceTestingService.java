package com.mz.example.service.identity;

import com.mz.example.db.base.entity.BaseEntity;
import com.mz.example.db.identity.entity.*;
import com.mz.example.db.identity.repository.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//TODO: Service vs Component?
@Service
public class IdentityPerformanceTestingService {

    public static final int MAX_PACKAGE_SIZE = 100;
    private static final int DATA_LENGTH = 70;

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

    /**
     * @param packageSize simulates how many records should be created from input data.
     *                    If this was a real example we would have {@link java.util.List}
     *                    of input events that should be saved in DB. And {@link List#size()}
     *                    would be equal to <code>packageSize</code>.
     */
    @Transactional
    public void performanceTest(int packageSize){
        if(packageSize < 0 || packageSize > MAX_PACKAGE_SIZE){
            throw new IllegalArgumentException("Invalid package size: "+packageSize);
        }
        for(int i = 0; i < packageSize; ++i){
            PrimaryTable primaryTable = fillWithData(new PrimaryTable());
            NestedTable1 nestedTable1 = fillWithData(new NestedTable1());
            NestedTable2 nestedTable2 = fillWithData(new NestedTable2());
            NestedTable3 nestedTable3 = fillWithData(new NestedTable3());
            NestedTable4 nestedTable4 = fillWithData(new NestedTable4());

            primaryTableRepository.save(primaryTable);
            nestedTable1Repository.save(nestedTable1);
            nestedTable2Repository.save(nestedTable2);
            nestedTable3Repository.save(nestedTable3);
            nestedTable4Repository.save(nestedTable4);
        }
    }

    private <ENTITY extends BaseEntity> ENTITY fillWithData(ENTITY input){
        input.setColumn1(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn2(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn3(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn4(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn5(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn6(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn7(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn8(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn9(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn10(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn11(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn12(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn13(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn14(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn15(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn16(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn17(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn18(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn19(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn20(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn21(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn22(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn23(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn24(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn25(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn26(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn27(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn28(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn29(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        input.setColumn30(RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase());
        return input;
    }
}
