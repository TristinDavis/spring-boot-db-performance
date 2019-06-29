package com.mz.example.db.one_to_one.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PRIMARY_TABLE", schema = "ONE_TO_ONE")
public class PrimaryTable extends OneToOneBaseEntity{

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private NestedTable1 nestedTable1;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private NestedTable2 nestedTable2;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private NestedTable3 nestedTable3;
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private NestedTable4 nestedTable4;
}
