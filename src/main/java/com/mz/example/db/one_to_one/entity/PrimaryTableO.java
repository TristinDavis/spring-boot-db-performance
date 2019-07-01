package com.mz.example.db.one_to_one.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PRIMARY_TABLE", schema = "ONE_TO_ONE")
public class PrimaryTableO extends OneToOneBaseEntity{

    @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private NestedTable1O nestedTable1;
    @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private NestedTable2O nestedTable2;
    @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private NestedTable3O nestedTable3;
    @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private NestedTable4O nestedTable4;
}
