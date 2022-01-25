package com.dataload.demo.service;

import com.dataload.demo.dao.DosisRepository;
import com.dataload.demo.model.Dosis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DosisService {
   
  @Autowired
   private DosisRepository dosisRepository;

   public DosisService(DosisRepository dosisRepository){
     this.dosisRepository=dosisRepository;
   }
   
   public void addDosis(Dosis dosis){
     dosisRepository.save(dosis);
   }

}
