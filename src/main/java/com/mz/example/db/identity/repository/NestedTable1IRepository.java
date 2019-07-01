package com.mz.example.db.identity.repository;

import com.mz.example.db.identity.entity.NestedTable1I;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestedTable1IRepository extends CrudRepository<NestedTable1I, Long>{
}
