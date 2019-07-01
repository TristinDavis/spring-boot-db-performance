package com.mz.example.service;

import com.mz.example.db.base.entity.BaseEntity;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

public abstract class BasePerformanceTestingService {

    public static final int MAX_PACKAGE_SIZE = 100;
    private static final int DATA_LENGTH = 70;

    /**
     * @param packageSize simulates how many records should be created from input data.
     *                    If this was a real example we would have {@link java.util.List}
     *                    of input events that should be saved in DB. And {@link List#size()}
     *                    would be equal to <code>packageSize</code>.
     */
    public abstract void performanceTest(int packageSize);

    protected <ENTITY extends BaseEntity> ENTITY fillWithData(ENTITY input){
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
