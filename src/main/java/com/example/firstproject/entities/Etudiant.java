package com.example.firstproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Etudiant")

public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ETUDIANT_ID")
    private Integer Idetudiant;
    @Column(name = "PRENOM_ETUDIANT")
    private String prenom;
    @Column(name = "NOM_ETUDIANT")
    private String nom;
    @Enumerated(EnumType.STRING)
   private option option;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="etudiant")
    private Set<Contrat> contrat;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Equipe> equipes;
    @ManyToOne
   private Departement departement;

}
