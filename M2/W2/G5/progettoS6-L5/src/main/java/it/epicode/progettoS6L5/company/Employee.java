package it.epicode.progettoS6L5.company;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "employee")
@Data
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseEntity {
    @Column (name = "first_name", nullable = false)
    private String firstName;
    @Column (name = "last_name", nullable = false)
    private String lastName;
    @Column (name = "nickname", nullable = false)
    private String nickName;
    @Column (name = "email", nullable = false)
    private String email;
    @OneToMany(mappedBy = "employee")
    private List<Device> devices;
}
