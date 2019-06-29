package com.mz.example.db.identity.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRIMARY_TABLE", schema = "IDENTITY_SCHEMA")
public class PrimaryTable extends IdentityBaseEntity{
}
