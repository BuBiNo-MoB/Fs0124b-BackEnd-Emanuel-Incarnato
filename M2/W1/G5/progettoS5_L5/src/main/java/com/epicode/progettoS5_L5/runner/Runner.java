package com.epicode.progettoS5_L5.runner;

import com.epicode.progettoS5_L5.data.Building;
import com.epicode.progettoS5_L5.data.Type;
import com.epicode.progettoS5_L5.data.User;
import com.epicode.progettoS5_L5.data.Workstation;
import com.epicode.progettoS5_L5.repository.BuildingRepository;
import com.epicode.progettoS5_L5.repository.ReservationRepository;
import com.epicode.progettoS5_L5.repository.UserRepository;
import com.epicode.progettoS5_L5.repository.WorkstationRepository;
import com.epicode.progettoS5_L5.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {
    private final BuildingRepository buildingRepository;
    private final UserRepository userRepository;
    private final WorkstationRepository workstationRepository;
    private final ReservationRepository reservationRepository;
    private final ReservationService reservationService;

    @Autowired
    public Runner(BuildingRepository buildingRepository, UserRepository userRepository, WorkstationRepository workstationRepository, ReservationRepository reservationRepository, ReservationService reservationService) {
        this.buildingRepository = buildingRepository;
        this.userRepository = userRepository;
        this.workstationRepository = workstationRepository;
        this.reservationRepository = reservationRepository;
        this.reservationService = reservationService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            Building building0 = Building.builder()
                    .withName("Sala 1")
                    .withAddress("Via della sala 1")
                    .withCity("Roma")
                    .build();

            Building building1 = Building.builder()
                    .withName("Sala 2")
                    .withAddress("Via della Sala 2")
                    .withCity("Roma")
                    .build();

            Building building2 = Building.builder()
                    .withName("Sala 3")
                    .withAddress("Via della Sala 3")
                    .withCity("Roma")
                    .build();

            User user0 = User.builder()
                    .withId(1L)
                    .withName("Ema Inca")
                    .withEmail("ema@inca.com")
                    .withUsername("0")
                    .build();

            User user1 = User.builder()
                    .withId(2L)
                    .withName("Queen Inca")
                    .withEmail("queen.inca.com")
                    .withUsername("1")
                    .build();

            User user2 = User.builder()
                    .withId(3L)
                    .withName("Fra Sba")
                    .withEmail("fra@sba.com")
                    .withUsername("2")
                    .build();

            Workstation workstation0 = Workstation.builder()
                    .withId(1L)
                    .withBuilding(building0)
                    .withDescription("Sala usata per fare le riunioni")
                    .withMaxUser(4)
                    .withType(Type.PRIVATE)
                    .build();

            Workstation workstation1 = Workstation.builder()
                    .withId(2L)
                    .withBuilding(building0)
                    .withDescription("Sala usata")
                    .withMaxUser(9)
                    .withType(Type.OPEN_SPACE)
                    .build();

            Workstation workstation2 = Workstation.builder()
                    .withId(3L)
                    .withBuilding(building0)
                    .withDescription("Sala")
                    .withMaxUser(2)
                    .withType(Type.MEETING_ROOM)
                    .build();

            buildingRepository.save(building0);
            buildingRepository.save(building1);
            buildingRepository.save(building2);
            userRepository.save(user0);
            userRepository.save(user1);
            userRepository.save(user2);
            workstationRepository.save(workstation0);
            workstationRepository.save(workstation1);
            workstationRepository.save(workstation2);

            reservationService.createReservation(user1.getId(), workstation0.getId(), LocalDate.now().plusYears(1));
            reservationService.createReservation(user0.getId(), workstation2.getId(), LocalDate.now().plusMonths(1));
            reservationService.createReservation(user2.getId(), workstation1.getId(), LocalDate.now().plusDays(1));

            System.out.println("Edifici salvati correttamente");
            System.out.println("User salvati correttamente");
            System.out.println("Postazioni salvate correttamente");
            System.out.println(reservationService.createReservation(user1.getId(), workstation0.getId(), LocalDate.now()));
            System.out.println(reservationService.createReservation(user0.getId(), workstation2.getId(), LocalDate.now()));
            System.out.println(reservationService.createReservation(user2.getId(), workstation1.getId(), LocalDate.now().plusDays(1)));

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("basta");
        }
    }
}
