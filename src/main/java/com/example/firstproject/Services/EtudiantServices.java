package com.example.firstproject.Services;

import com.example.firstproject.entities.Etudiant;
import com.example.firstproject.repositories.IEtudiantRepository;

public class EtudiantServices {
    IEtudiantService etudiantService;

    Etudiant addEtudiant(Etudiant etudiant){
        return etudiantService.addEtudiant(etudiant);
    }
}
