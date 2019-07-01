package com.mz.example.db.long_id.repository;

import com.mz.example.db.long_id.entity.NestedTable1L;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestedTable1LRepository extends CrudRepository<NestedTable1L, Long>{
}
