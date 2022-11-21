package tn.esprit.firstproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Equipe;
@Repository
public interface IEquipeRepository extends CrudRepository<Equipe, Integer> {
}
