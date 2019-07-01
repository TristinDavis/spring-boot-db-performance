package com.mz.example.db.identity.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRIMARY_TABLE", schema = "IDENTITY_SCHEMA")
//TODO: why I can't have entities with same class name referring tables in different schemas?:
// https://stackoverflow.com/questions/56817669/crudrepository-uses-incorrect-table-schema-for-selecting-entities
// https://jira.spring.io/browse/DATAJPA-1566
public class PrimaryTableI extends IdentityBaseEntity{
}
