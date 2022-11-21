package tn.esprit.firstproject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.entities.Universite;

import java.util.List;

@Repository
public interface IUniversiteRepository extends CrudRepository<Universite, Integer> {
    @Query("select e.departements from Universite e where e.idUniv=?1")
    List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}
