package com.mz.example.db.identity.repository;

import com.mz.example.db.identity.entity.NestedTable2I;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestedTable2IRepository extends CrudRepository<NestedTable2I, Long>{
}
