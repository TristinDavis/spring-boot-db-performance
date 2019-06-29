package com.mz.example.db.identity.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "NESTED_TABLE_2", schema = "IDENTITY_SCHEMA")
public class NestedTable2 extends IdentityBaseEntity{
}
