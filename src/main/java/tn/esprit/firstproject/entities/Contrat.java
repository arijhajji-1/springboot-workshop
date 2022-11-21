package tn.esprit.firstproject.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
public class Contrat  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContrat ;
    @Temporal (TemporalType.DATE)
    private Date dateDebutContrat ;
    @Temporal (TemporalType.DATE)
    private Date dateFinContrat ;
    @Enumerated(EnumType.STRING)
    private Specialite specialite ;
    private Boolean archive ;
    private Integer montantContrat ;

    @ManyToOne
    Etudiant etudiant  ;

}
