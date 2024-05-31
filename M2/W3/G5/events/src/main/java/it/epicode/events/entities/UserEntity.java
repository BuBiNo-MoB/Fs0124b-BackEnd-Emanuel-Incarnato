package it.epicode.events.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class UserEntity extends BaseEntity{

    private String email;

    private String password;

    private String username;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private final List<RoleEntity> roles =new ArrayList<>();
}
