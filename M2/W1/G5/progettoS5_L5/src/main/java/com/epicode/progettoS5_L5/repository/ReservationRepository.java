package com.epicode.progettoS5_L5.repository;

import com.epicode.progettoS5_L5.data.Reservation;
import com.epicode.progettoS5_L5.data.User;
import com.epicode.progettoS5_L5.data.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserAndDateReservation (User user, LocalDate dateReservation);
    boolean existsByWorkstationAndDateReservation(Workstation workstation, LocalDate dateReservation);
    boolean existsByUserAndDateReservation(User user, LocalDate dateReservation);
}
