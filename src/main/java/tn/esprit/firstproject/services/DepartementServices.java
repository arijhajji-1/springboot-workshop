package tn.esprit.firstproject.services;

import org.springframework.stereotype.Component;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.repositories.IDepartementRepository;

@Component
public class DepartementServices {
    IDepartementRepository departementRepository ;

    Departement addDepartement(Departement departement) { return departementRepository.save(departement) ; }
}
