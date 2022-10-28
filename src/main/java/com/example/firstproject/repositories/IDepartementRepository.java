package com.example.firstproject.repositories;

import com.example.firstproject.entities.Departement;
import org.springframework.data.repository.CrudRepository;

public interface IDepartementRepository extends CrudRepository<Departement,Integer> {
}
