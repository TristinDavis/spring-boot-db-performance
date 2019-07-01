package com.mz.example.db.long_id.repository;

import com.mz.example.db.long_id.entity.PrimaryTableL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryTableLRepository extends CrudRepository<PrimaryTableL, Long>{
}
