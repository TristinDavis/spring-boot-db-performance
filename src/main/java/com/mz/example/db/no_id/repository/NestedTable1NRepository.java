package com.mz.example.db.no_id.repository;

import com.mz.example.db.no_id.entity.NestedTable1N;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestedTable1NRepository extends CrudRepository<NestedTable1N, Long>{
}
