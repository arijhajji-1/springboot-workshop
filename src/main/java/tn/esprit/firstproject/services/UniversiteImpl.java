package tn.esprit.firstproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.entities.Universite;
import tn.esprit.firstproject.repositories.IDepartementRepository;
import tn.esprit.firstproject.repositories.IUniversiteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversiteImpl implements IUniversiteService{

    @Autowired
    private final IUniversiteRepository universiteRepository ;
    @Autowired
    private final IDepartementRepository departementRepository;
    @Override
    public List<Universite> retrieveAllUniversites() {
        return (List<Universite>) universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite universite) {

        return universiteRepository.save(universite) ;
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u) ;
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById(idUniversite).get() ;
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniv, Integer idDep) {
        Universite univ = universiteRepository.findById(idUniv).orElse(null) ;
        Departement depart = departementRepository.findById(idDep).orElse(null) ;
        univ.getDepartements().add(depart);
        universiteRepository.save(univ);
    }
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite)
    {
        return universiteRepository.retrieveDepartementsByUniversite(idUniversite);
    }
}
