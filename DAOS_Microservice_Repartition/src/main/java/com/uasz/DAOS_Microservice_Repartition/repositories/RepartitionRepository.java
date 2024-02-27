package com.uasz.DAOS_Microservice_Repartition.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uasz.DAOS_Microservice_Repartition.models.Repartition;


public interface RepartitionRepository extends JpaRepository<Repartition, Long>{
}
