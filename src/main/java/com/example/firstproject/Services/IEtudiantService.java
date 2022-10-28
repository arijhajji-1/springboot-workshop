package com.example.firstproject.Services;

import com.example.firstproject.entities.Etudiant;



public interface IEtudiantService {
    Etudiant addEtudiant(Etudiant etudiant);
    void removeEtudiant(Integer idEtudiant);
}
