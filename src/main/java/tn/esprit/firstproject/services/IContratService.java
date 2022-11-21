package tn.esprit.firstproject.services;

import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Contrat;

import java.util.Date;
import java.util.List;

@Service
public interface IContratService {
    List<Contrat> retrieveAllContrats();
    Contrat updateContrat (Contrat ce);
    Contrat addContrat(Contrat ce) ;
    Contrat retrieveContrat (Integer idContrat);
    void removeContrat(Integer idContrat) ;

    Integer nbContratsValides(Date startDate, Date endDate);

    Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE);

    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

    List<Contrat> contratBetween2dates(Date startDate, Date endDate);
}
