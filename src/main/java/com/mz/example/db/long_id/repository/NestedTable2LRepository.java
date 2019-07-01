package com.mz.example.db.long_id.repository;

import com.mz.example.db.long_id.entity.NestedTable2L;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestedTable2LRepository extends CrudRepository<NestedTable2L, Long>{
}
