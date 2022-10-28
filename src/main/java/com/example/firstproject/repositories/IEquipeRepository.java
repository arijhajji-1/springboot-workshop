package com.example.firstproject.repositories;

import com.example.firstproject.entities.Equipe;
import org.springframework.data.repository.CrudRepository;

public interface IEquipeRepository extends CrudRepository<Equipe,Integer> {
}
