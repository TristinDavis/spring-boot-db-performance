package com.mz.example.db.identity.repository;

import com.mz.example.db.identity.entity.NestedTable2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestedTable2Repository extends CrudRepository<NestedTable2, Long>{
}
