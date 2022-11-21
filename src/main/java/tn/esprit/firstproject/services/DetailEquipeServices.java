package tn.esprit.firstproject.services;

import org.springframework.stereotype.Component;
import tn.esprit.firstproject.entities.DetailEquipe;
import tn.esprit.firstproject.repositories.IDetailEquipeRepository;

@Component
public class DetailEquipeServices {
    IDetailEquipeRepository detailEquipeRepository ;

    DetailEquipe addDetailEquipe(DetailEquipe detailEquipe) { return detailEquipeRepository.save(detailEquipe) ; }
}
