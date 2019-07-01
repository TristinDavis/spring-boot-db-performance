package com.mz.example.db.no_id.repository;

import com.mz.example.db.no_id.entity.NestedTable3N;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestedTable3NRepository extends CrudRepository<NestedTable3N, Long>{
}
