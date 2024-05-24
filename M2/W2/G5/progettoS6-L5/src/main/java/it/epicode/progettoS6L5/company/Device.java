package it.epicode.progettoS6L5.company;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Entity
@Table(name = "device")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")

public class Device  extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Enumerated (EnumType.STRING)
    private DeviceType deviceType;

    @Enumerated (EnumType.STRING)
    private DeviceStatus deviceStatus;


}
