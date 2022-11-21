package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.DetailEquipe;
import tn.esprit.firstproject.repositories.IDetailEquipeRepository;

public class DetailEquipeImpl implements IDetailEquipeService{
    IDetailEquipeRepository detailEquipeRepository ;
    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe detailEquipe) {
        return detailEquipeRepository.save(detailEquipe);
    }

    @Override
    public void removeDetailEquipe(Integer idDetailEquipe) {
        detailEquipeRepository.deleteById(idDetailEquipe);
    }
}
