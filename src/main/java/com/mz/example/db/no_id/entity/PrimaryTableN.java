package com.mz.example.db.no_id.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PRIMARY_TABLE", schema = "NO_ID")
public class PrimaryTableN extends NoIdBaseEntity {
}
