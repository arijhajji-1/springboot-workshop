package tn.esprit.firstproject.services;

import org.springframework.stereotype.Component;
import tn.esprit.firstproject.entities.Equipe;
import tn.esprit.firstproject.repositories.IEquipeRepository;

@Component
public class EquipeServices {
    IEquipeRepository equipeRepository ;

    Equipe addEquipe(Equipe equipe) { return equipeRepository.save(equipe) ; }
}
