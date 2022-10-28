package com.example.firstproject.Services;

import com.example.firstproject.entities.Etudiant;
import com.example.firstproject.repositories.IEtudiantRepository;

public class EtudiantImp implements IEtudiantService {
    IEtudiantRepository etudiantRepository;
    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
etudiantRepository.deleteById(idEtudiant);
    }
}
