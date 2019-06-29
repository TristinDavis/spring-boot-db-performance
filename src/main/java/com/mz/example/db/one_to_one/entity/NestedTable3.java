package com.mz.example.db.one_to_one.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "NESTED_TABLE_3", schema = "ONE_TO_ONE")
public class NestedTable3 extends OneToOneBaseEntity{
}
