package com.uasz.DAOS_Microservice_Repartition.models;

import java.util.Date;
import java.util.List;

//import com.uasz.Gestion_DAOS.Modele.emploi.Seance;
//import com.uasz.Gestion_DAOS.Modele.maquette.Enseignement;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repartition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRepartition;
    private String descriptionRepartition;
    @Temporal(TemporalType.DATE)
    private Date dateCreationRepartition;

    /*@ManyToOne
    @JoinColumn(name = "enseignement")
    private Enseignement enseignement;*/

    @ManyToOne
    @JoinColumn(name = "enseignant")
    private Enseignant enseignant;

    /*@OneToMany(mappedBy = "repartition", cascade = CascadeType.ALL)
    private List<Seance> seances;*/
}