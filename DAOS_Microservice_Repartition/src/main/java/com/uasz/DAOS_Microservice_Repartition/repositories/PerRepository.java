package com.uasz.DAOS_Microservice_Repartition.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.uasz.DAOS_Microservice_Repartition.models.PER;

@Repository
public interface PerRepository extends JpaRepository<PER, Long>{
}
