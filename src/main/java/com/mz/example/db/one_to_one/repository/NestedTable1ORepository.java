package com.mz.example.db.one_to_one.repository;

import com.mz.example.db.one_to_one.entity.NestedTable1O;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestedTable1ORepository extends CrudRepository<NestedTable1O, Long>{
}
