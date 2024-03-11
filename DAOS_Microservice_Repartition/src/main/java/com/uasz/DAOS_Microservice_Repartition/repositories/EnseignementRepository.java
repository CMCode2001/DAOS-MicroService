package com.uasz.DAOS_Microservice_Repartition.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uasz.DAOS_Microservice_Repartition.models.Enseignement;

public interface EnseignementRepository extends JpaRepository<Enseignement, Long> {
}
