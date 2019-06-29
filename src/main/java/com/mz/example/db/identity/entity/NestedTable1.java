package com.mz.example.db.identity.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "NESTED_TABLE_1", schema = "IDENTITY_SCHEMA")
public class NestedTable1 extends IdentityBaseEntity{
}
