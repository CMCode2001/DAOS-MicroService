package com.uasz.DAOS_Microservice_Maquette.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uasz.DAOS_Microservice_Maquette.models.Module;

public interface ModuleRepository extends JpaRepository<Module, Long> {
}
