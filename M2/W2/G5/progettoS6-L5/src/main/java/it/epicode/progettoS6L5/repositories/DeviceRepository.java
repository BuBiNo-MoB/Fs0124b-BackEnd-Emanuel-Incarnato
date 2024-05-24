package it.epicode.progettoS6L5.repositories;

import it.epicode.progettoS6L5.company.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long>, PagingAndSortingRepository<Device, Long> {
}