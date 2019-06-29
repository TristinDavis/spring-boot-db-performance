package com.mz.example.db.identity.repository;

import com.mz.example.db.identity.entity.PrimaryTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryTableRepository extends CrudRepository<PrimaryTable, Long>{
}
