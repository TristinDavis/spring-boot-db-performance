package com.mz.example.db.one_to_one.repository;

import com.mz.example.db.one_to_one.entity.NestedTable2O;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestedTable2ORepository extends CrudRepository<NestedTable2O, Long>{
}
