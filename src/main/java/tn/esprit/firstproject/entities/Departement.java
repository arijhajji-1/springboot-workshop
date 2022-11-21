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
public class Departement  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepart ;
    private String nomDepart ;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departement")
    private Set<Etudiant> etudiants ;
}
