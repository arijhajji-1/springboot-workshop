package tn.esprit.firstproject.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Departement;

import java.util.List;

@Service
public interface IDepartementService {
    List<Departement> retrieveAllDepartements();
    Departement addDepartement(Departement d) ;
    Departement updateDepartement (Departement d);
    Departement retrieveDepartement (Integer idDepart);

    Departement affecterEtudiant(Integer idDep, Integer idEtudiant) ;

}
