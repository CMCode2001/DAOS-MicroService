package com.uasz.DAOS_Microservice_Repartition.Maquette_Service.Model;

import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UE {
    private Long idUE;
    private String libelleUE;
    private  String codeUE;
    private int creditUE;
    private int coefficientUE;
    private String descriptionUE;
    @Temporal(TemporalType.DATE)
    private Date dateCreationUE;
}