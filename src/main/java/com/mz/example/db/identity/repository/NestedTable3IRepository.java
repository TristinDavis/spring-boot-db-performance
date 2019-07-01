package com.mz.example.db.identity.repository;

import com.mz.example.db.identity.entity.NestedTable3I;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestedTable3IRepository extends CrudRepository<NestedTable3I, Long>{
}
