package com.example.firstproject.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "DetailEquipe")
@NoArgsConstructor
public class DetailEquipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DETAILEQUIPE_ID")
    private Integer idDetailEquipe;
    @Column(name = "DETAILEQUIPE_SALLE")
    private Integer salle;
    @Column(name = "DETAILEQUIPE_THEMATIQUE")
    private String thematique;
    @OneToOne(mappedBy="detailEquipe")
    private Equipe equipe;
}
