package com.mz.example.db.identity.repository;

import com.mz.example.db.identity.entity.PrimaryTableI;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryTableIRepository extends CrudRepository<PrimaryTableI, Long>{
}
