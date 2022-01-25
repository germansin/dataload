package com.dataload.demo.dao;

import com.dataload.demo.model.Dosis;

import org.springframework.data.repository.CrudRepository;

public interface DosisRepository extends CrudRepository<Dosis,Long>{
    
}
