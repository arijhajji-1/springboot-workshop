package tn.esprit.firstproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Contrat;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.entities.Specialite;
import tn.esprit.firstproject.repositories.IContratRepository;
import tn.esprit.firstproject.repositories.IEtudiantRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratImpl implements  IContratService {
    @Autowired
   private final IContratRepository contratRepository ;
    @Autowired
   private final IEtudiantRepository etudiantRepository ;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return (List<Contrat>) contratRepository.findAll();
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return contratRepository.save(ce) ;
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepository.save(ce) ;
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat).orElse(null) ;
    }

    @Override
    public void removeContrat(Integer idContrat) {
        contratRepository.deleteById(idContrat);
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        return contratRepository.nbContratsValides(startDate,endDate);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant e = etudiantRepository.findEtudiantByPrenomEtNom(prenomE,nomE) ;

        e.getContrats().add(ce);
        ce.setEtudiant(e);
        contratRepository.save(ce);
        etudiantRepository.save(e);
        return ce ;
    }
    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> listContrat=contratRepository.contratBetween2dates(startDate,endDate);
        System.out.println(listContrat);
        float chiffre=0;
        for( Contrat c:listContrat){
            if(c.getSpecialite().equals(Specialite.IA)){
                chiffre=chiffre+300;
            }
            else if (c.getSpecialite().equals(Specialite.RESEAUX)){
                chiffre=chiffre+350;
            }
            else if(c.getSpecialite().equals(Specialite.CLOUD)){
                chiffre=chiffre+400;
            }
            else if (c.getSpecialite().equals(Specialite. SECURITE)){
                chiffre=chiffre+450;
            }
        }
        return chiffre;
    }

    @Override
    public List<Contrat> contratBetween2dates(Date startDate, Date endDate) {
        return  contratRepository.contratBetween2dates(startDate,endDate);
    }

  /* public String retrieveAndUpdateStatusContrat()
    {
        List<Contrat> contrats = (List<Contrat>) contratRepository.findAll();
        List<Contrat> contratRenouv = null ;
        String result="\n============================================================================= \n" ;
        result=result + "Les contrats dont la date fin est prévue dans les prochaines 15 jours sont : \n" ;
        for (Contrat c : contrats) {
            int period = contratRepository.DateDiffContrat(c.getIdContrat()) ; // calcul difference jours
            if (period<=15) {
                result = result+"Contrat id : "+c.getIdContrat()+"\n" ;
                result = result+"Jours Restant : "+ period +"\n" ;
                result = result+"Date Fin : "+c.getDateFinContrat()+"\n" ;
                result = result+"Specialite : "+c.getSpecialite()+"\n" ;
                result = result+"Etudiant Concerné : "+c.getEtudiant().getNom()+"\n" ;
            }
            if (period<=0) {
                c.setArchive(true);
                contratRepository.save(c) ;
            }
        }

        System.out.println(result);
        return result;
    }*/


}
