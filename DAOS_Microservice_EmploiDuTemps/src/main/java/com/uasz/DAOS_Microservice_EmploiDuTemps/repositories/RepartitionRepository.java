package com.uasz.DAOS_Microservice_EmploiDuTemps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Repartition;

public interface RepartitionRepository extends JpaRepository<Repartition, Long> {
    
}
