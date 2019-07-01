package com.mz.example.db.one_to_one.repository;

import com.mz.example.db.one_to_one.entity.NestedTable3O;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestedTable3ORepository extends CrudRepository<NestedTable3O, Long>{
}
