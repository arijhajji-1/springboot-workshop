package com.example.firstproject.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Contrat")
@NoArgsConstructor
public class Contrat implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTRAT_ID")
    private Integer Idcontrat;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_DEBUTCONTRAT")
    private Date dateDebutcontrat;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_FINCONTRAT")
    private Date dateFincontrat;
    @Column(name = "MONTANT_CONTRAT")
    private Integer montantContrat;
    @Enumerated(EnumType.ORDINAL)
     private specialite specialite;
    @ManyToOne
    Etudiant etudiant;
}
