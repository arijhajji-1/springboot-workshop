package tn.esprit.firstproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Equipe;
import tn.esprit.firstproject.repositories.IEquipeRepository;

import java.util.List;

@Service
public class EquipeImpl implements IEquipeService{
    @Autowired
    IEquipeRepository equipeRepository ;

    @Override
    public List<Equipe> retrieveAllEquipes() {
        return (List<Equipe>) equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe equipe) {

        return equipeRepository.save(equipe);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).get() ;
    }
}
