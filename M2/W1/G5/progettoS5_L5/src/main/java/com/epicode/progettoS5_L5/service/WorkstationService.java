package com.epicode.progettoS5_L5.service;

import com.epicode.progettoS5_L5.data.Building;
import com.epicode.progettoS5_L5.data.Type;
import com.epicode.progettoS5_L5.data.Workstation;
import com.epicode.progettoS5_L5.repository.BuildingRepository;
import com.epicode.progettoS5_L5.repository.WorkstationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class WorkstationService {

    @Autowired
    private WorkstationRepository workstationRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    public Workstation findById(Long id) {
        Optional<Workstation> workstationOptional = workstationRepository.findById(id);
        return workstationOptional.orElse(null);
    }

    public List<WorkstationRepository> findByTypeOfWorkStationAndBuilding(Type type, String city) {
        Building building = buildingRepository.findByCity(city);

        if (building != null) {
            return workstationRepository.findByTypeAndBuilding(type, building);
        } else {
            return Collections.emptyList();
        }
    }
}
