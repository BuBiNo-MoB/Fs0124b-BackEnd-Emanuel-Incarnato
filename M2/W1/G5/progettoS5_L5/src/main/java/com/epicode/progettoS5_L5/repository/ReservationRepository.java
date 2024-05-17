package com.epicode.progettoS5_L5.repository;

import com.epicode.progettoS5_L5.data.Reservation;
import com.epicode.progettoS5_L5.data.User;
import com.epicode.progettoS5_L5.data.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByUserAndDate (User user, LocalDate date);
    boolean existsByWorkstationAndDate(Workstation workstation, LocalDate date);
}
