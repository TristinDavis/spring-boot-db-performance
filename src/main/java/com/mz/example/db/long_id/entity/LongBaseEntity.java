package com.mz.example.db.long_id.entity;

import com.mz.example.db.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class LongBaseEntity extends BaseEntity{

    @Id
    @Column(name = "ID")
    private Long id;
}
