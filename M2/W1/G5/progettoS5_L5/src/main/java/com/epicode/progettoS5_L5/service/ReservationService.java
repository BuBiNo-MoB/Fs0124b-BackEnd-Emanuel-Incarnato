package com.epicode.progettoS5_L5.service;


import com.epicode.progettoS5_L5.data.Reservation;
import com.epicode.progettoS5_L5.data.User;
import com.epicode.progettoS5_L5.data.Workstation;
import com.epicode.progettoS5_L5.repository.ReservationRepository;
import com.epicode.progettoS5_L5.repository.UserRepository;
import com.epicode.progettoS5_L5.repository.WorkstationRepository;
import org.hibernate.dialect.function.ListaggStringAggEmulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private WorkstationRepository workstationRepository;

    @Autowired
    private UserRepository userRepository;

    public Reservation createReservation(Long userId, Long workstationId, LocalDate dateReservation){
        User user = userRepository.findById(userId)
                .orElseThrow( () -> new RuntimeException("User not found"));
        Workstation workstation = workstationRepository.findById(workstationId)
                .orElseThrow( () -> new RuntimeException("Workstation not found"));

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setWorkstation(workstation);
        reservation.setDateReservation(dateReservation);

        return reservationRepository.save(reservation);
    }

    public boolean isUserAlreadyReserved(User user, LocalDate dateReservation){
        return reservationRepository.existsByUserAndDateReservation(user, dateReservation);
    }

    public boolean isWorkstationAvailable(Workstation workstation, LocalDate dateReservation){
        return !reservationRepository.existsByWorkstationAndDateReservation(workstation, dateReservation);
    }

    public List<Reservation> reservationsByUserAndDate(User user, LocalDate dateReservation){
        return reservationRepository.findByUserAndDateReservation(user, dateReservation);
    }
}
