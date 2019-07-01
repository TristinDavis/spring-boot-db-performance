package com.mz.example.db.no_id.repository;

import com.mz.example.db.no_id.entity.PrimaryTableN;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryTableNRepository extends CrudRepository<PrimaryTableN, Long>{
}
