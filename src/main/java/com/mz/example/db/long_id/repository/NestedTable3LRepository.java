package com.mz.example.db.long_id.repository;

import com.mz.example.db.long_id.entity.NestedTable3L;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestedTable3LRepository extends CrudRepository<NestedTable3L, Long>{
}
