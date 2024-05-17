package com.epicode.progettoS5_L5.repository;

import com.epicode.progettoS5_L5.data.Building;
import com.epicode.progettoS5_L5.data.Type;
import com.epicode.progettoS5_L5.data.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorkstationRepository extends JpaRepository<Workstation, Integer> {
    List<WorkstationRepository> findByTypeAndBuilding (Type worktype, Building building);
    Optional<Workstation> findById(long id);

}
