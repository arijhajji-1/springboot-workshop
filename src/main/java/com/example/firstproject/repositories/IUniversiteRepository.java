package com.example.firstproject.repositories;

import com.example.firstproject.entities.Universite;
import org.springframework.data.repository.CrudRepository;

public interface IUniversiteRepository extends CrudRepository<Universite,Integer> {
}
