package com.epicode.progettoS5_L5.service;


import com.epicode.progettoS5_L5.data.Reservation;
import com.epicode.progettoS5_L5.data.User;
import com.epicode.progettoS5_L5.data.Workstation;
import com.epicode.progettoS5_L5.repository.ReservationRepository;
import com.epicode.progettoS5_L5.repository.UserRepository;
import com.epicode.progettoS5_L5.repository.WorkstationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private WorkstationRepository workstationRepository;

    @Autowired
    private UserRepository userRepository;

    public ReservationRepository createReservation(String username, Long workstationId, LocalDate date){
        User user = userRepository.findById(Integer.valueOf(username))
                .orElseThrow( () -> new RuntimeException("User not found"));
        Workstation workstation = (Workstation) workstationRepository.findById(Math.toIntExact(workstationId))
                .orElseThrow( () -> new RuntimeException("Workstation not found"));

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setWorkstation(workstation);
        reservation.setDate(date);

        return (ReservationRepository) reservationRepository.save(reservation);
    }
}
