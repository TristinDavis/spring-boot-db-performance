package com.mz.example.db.identity.repository;

import com.mz.example.db.identity.entity.NestedTable3;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestedTable3Repository extends CrudRepository<NestedTable3, Long>{
}
