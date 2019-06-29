package com.mz.example.db.one_to_one.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "NESTED_TABLE_1", schema = "ONE_TO_ONE")
public class NestedTable1 extends OneToOneBaseEntity{
}
