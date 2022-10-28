package com.example.firstproject.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Equipe")
@NoArgsConstructor
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EQUIPE_ID")
   private Integer idEquipe;
    @Column(name = "EQUIPE_NOM")
    private String nomEquipe;
    @Enumerated(EnumType.ORDINAL)
    private niveau niveau;
    @ManyToMany(mappedBy="equipes", cascade = CascadeType.ALL)

    private Set<Etudiant> etudiants;
    @OneToOne
    private DetailEquipe detailEquipe;

}
