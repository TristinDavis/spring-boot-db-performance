package com.mz.example.db.no_id.repository;

import com.mz.example.db.no_id.entity.NestedTable4N;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestedTable4NRepository extends CrudRepository<NestedTable4N, Long>{
}
