package com.example.firstproject.repositories;

import com.example.firstproject.entities.Etudiant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface IEtudiantRepository extends CrudRepository<Etudiant,Integer> {
    List<Etudiant> findByPrenomNotNull();


    @Query("select e from Etudiant e inner join e.contrat contrat where contrat.dateDebutcontrat = ?1")
    List<Etudiant> findByContrat_DateDebutcontrat(Date dateDebutcontrat);


}
