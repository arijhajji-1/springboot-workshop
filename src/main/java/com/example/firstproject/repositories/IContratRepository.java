package com.example.firstproject.repositories;

import com.example.firstproject.entities.Contrat;
import org.springframework.data.repository.CrudRepository;


public interface IContratRepository extends CrudRepository<Contrat,Integer> {
}
