package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.DetailEquipe;

public interface IDetailEquipeService {
    DetailEquipe addDetailEquipe(DetailEquipe detailEquipe) ;

    void removeDetailEquipe(Integer idDetailEquipe) ;
}
