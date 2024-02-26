package com.uasz.DAOS_Microservice_EmploiDuTemps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uasz.DAOS_Microservice_EmploiDuTemps.models.Deroulement;


public interface DeroulementRepository extends JpaRepository<Deroulement, Long> {
}
