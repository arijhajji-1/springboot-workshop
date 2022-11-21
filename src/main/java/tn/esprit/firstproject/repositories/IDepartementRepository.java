package tn.esprit.firstproject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Departement;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDepartementRepository extends CrudRepository<Departement, Integer> {

}
