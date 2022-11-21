package tn.esprit.firstproject.services;

import org.springframework.stereotype.Component;
import tn.esprit.firstproject.entities.Universite;
import tn.esprit.firstproject.repositories.IUniversiteRepository;

@Component
public class UniversiteServices {
    IUniversiteRepository universiteRepository ;

    Universite addUniversite(Universite universite) { return universiteRepository.save(universite) ; }



}
