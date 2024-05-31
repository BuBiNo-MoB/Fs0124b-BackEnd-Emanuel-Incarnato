package it.epicode.events.entities;


import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Event extends BaseEntity{

    private String title;

    private String description;

    private String date;

    private String place;

    private Integer placesAvailable;

    private Boolean reservationAvailability;

}
