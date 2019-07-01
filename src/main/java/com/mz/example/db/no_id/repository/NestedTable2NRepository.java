package com.mz.example.db.no_id.repository;

import com.mz.example.db.no_id.entity.NestedTable2N;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestedTable2NRepository extends CrudRepository<NestedTable2N, Long>{
}
