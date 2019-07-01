package com.mz.example.service;

import com.mz.example.db.base.entity.BaseEntity;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

public abstract class BasePerformanceTestingService {

    private static final String CONSTANT_COLUMN_VALUE = "ZFYRD1C8DJGC6OG09TR9KFQEOECCLKAAKDJQSFNFFM2WQ6PZLZK2HT27ZM6CV1DLUVGXEQ";

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
        input.setColumn1(getColumnData());
        input.setColumn2(getColumnData());
        input.setColumn3(getColumnData());
        input.setColumn4(getColumnData());
        input.setColumn5(getColumnData());
        input.setColumn6(getColumnData());
        input.setColumn7(getColumnData());
        input.setColumn8(getColumnData());
        input.setColumn9(getColumnData());
        input.setColumn10(getColumnData());
        input.setColumn11(getColumnData());
        input.setColumn12(getColumnData());
        input.setColumn13(getColumnData());
        input.setColumn14(getColumnData());
        input.setColumn15(getColumnData());
        input.setColumn16(getColumnData());
        input.setColumn17(getColumnData());
        input.setColumn18(getColumnData());
        input.setColumn19(getColumnData());
        input.setColumn20(getColumnData());
        input.setColumn21(getColumnData());
        input.setColumn22(getColumnData());
        input.setColumn23(getColumnData());
        input.setColumn24(getColumnData());
        input.setColumn25(getColumnData());
        input.setColumn26(getColumnData());
        input.setColumn27(getColumnData());
        input.setColumn28(getColumnData());
        input.setColumn29(getColumnData());
        input.setColumn30(getColumnData());
        return input;
    }

    private String getColumnData(){
//        return RandomStringUtils.randomAlphanumeric(DATA_LENGTH).toUpperCase();
        return CONSTANT_COLUMN_VALUE;
    }
}
