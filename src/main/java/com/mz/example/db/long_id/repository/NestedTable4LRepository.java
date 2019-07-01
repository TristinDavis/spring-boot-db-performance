package com.mz.example.db.long_id.repository;

import com.mz.example.db.long_id.entity.NestedTable4L;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestedTable4LRepository extends CrudRepository<NestedTable4L, Long>{
}
