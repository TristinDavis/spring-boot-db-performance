package com.mz.example.db.one_to_one.repository;

import com.mz.example.db.one_to_one.entity.NestedTable4O;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestedTable4ORepository extends CrudRepository<NestedTable4O, Long>{
}
