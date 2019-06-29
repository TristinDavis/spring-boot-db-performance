package com.mz.example.db.base.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "COLUMN_1", length = 70)
    private String column1;
    @Column(name = "COLUMN_2", length = 70)
    private String column2;
    @Column(name = "COLUMN_3", length = 70)
    private String column3;
    @Column(name = "COLUMN_4", length = 70)
    private String column4;
    @Column(name = "COLUMN_5", length = 70)
    private String column5;
    @Column(name = "COLUMN_6", length = 70)
    private String column6;
    @Column(name = "COLUMN_7", length = 70)
    private String column7;
    @Column(name = "COLUMN_8", length = 70)
    private String column8;
    @Column(name = "COLUMN_9", length = 70)
    private String column9;
    @Column(name = "COLUMN_10", length = 70)
    private String column10;
    @Column(name = "COLUMN_11", length = 70)
    private String column11;
    @Column(name = "COLUMN_12", length = 70)
    private String column12;
    @Column(name = "COLUMN_13", length = 70)
    private String column13;
    @Column(name = "COLUMN_14", length = 70)
    private String column14;
    @Column(name = "COLUMN_15", length = 70)
    private String column15;
    @Column(name = "COLUMN_16", length = 70)
    private String column16;
    @Column(name = "COLUMN_17", length = 70)
    private String column17;
    @Column(name = "COLUMN_18", length = 70)
    private String column18;
    @Column(name = "COLUMN_19", length = 70)
    private String column19;
    @Column(name = "COLUMN_20", length = 70)
    private String column20;
    @Column(name = "COLUMN_21", length = 70)
    private String column21;
    @Column(name = "COLUMN_22", length = 70)
    private String column22;
    @Column(name = "COLUMN_23", length = 70)
    private String column23;
    @Column(name = "COLUMN_24", length = 70)
    private String column24;
    @Column(name = "COLUMN_25", length = 70)
    private String column25;
    @Column(name = "COLUMN_26", length = 70)
    private String column26;
    @Column(name = "COLUMN_27", length = 70)
    private String column27;
    @Column(name = "COLUMN_28", length = 70)
    private String column28;
    @Column(name = "COLUMN_29", length = 70)
    private String column29;
    @Column(name = "COLUMN_30", length = 70)
    private String column30;
}
