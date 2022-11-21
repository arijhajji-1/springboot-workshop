package tn.esprit.firstproject.services;

import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Equipe;

import java.util.List;
@Service
public interface IEquipeService {
    List<Equipe> retrieveAllEquipes();
    Equipe addEquipe(Equipe e) ;
    Equipe updateEquipe (Equipe e);

    Equipe retrieveEquipe (Integer idEquipe);
}
