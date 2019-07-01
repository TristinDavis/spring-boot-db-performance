package com.mz.example.db.one_to_one.repository;

import com.mz.example.db.one_to_one.entity.PrimaryTableO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryTableORepository extends CrudRepository<PrimaryTableO, Long>{
}
