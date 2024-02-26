package com.uasz.DAOS_Microservice_Repartition.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor 
@AllArgsConstructor
@DiscriminatorValue("PER")
public class PER extends Enseignant {
    private String matriculePer;
}
