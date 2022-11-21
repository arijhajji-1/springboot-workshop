package tn.esprit.firstproject.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
public class Universite  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUniv ;
    private String nom ;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Departement> departements;
}
