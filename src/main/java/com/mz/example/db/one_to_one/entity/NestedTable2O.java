package com.mz.example.db.one_to_one.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "NESTED_TABLE_2", schema = "ONE_TO_ONE")
public class NestedTable2O extends OneToOneBaseEntity{
}
