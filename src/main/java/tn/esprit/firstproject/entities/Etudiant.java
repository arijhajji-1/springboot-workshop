package tn.esprit.firstproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEtudiant ;
    private String prenom ;
    private String nom ;

@Enumerated(EnumType.STRING)
private Option op;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    Departement departement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiant")

    private Set<Contrat> contrats ;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Equipe> equipes ;
}
