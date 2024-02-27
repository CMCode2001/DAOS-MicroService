package com.uasz.DAOS_Microservice_Maquette.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.uasz.DAOS_Microservice_Maquette.models.*;

public interface UERepository extends JpaRepository<UE, Long>{

    @Query("SELECT e FROM EC e WHERE e.ue = ?1")
    List<EC> findByUE (UE ue);
}
