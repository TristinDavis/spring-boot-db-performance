package com.mz.example.db.identity.repository;

import com.mz.example.db.identity.entity.NestedTable1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestedTable1Repository extends CrudRepository<NestedTable1, Long>{
}
