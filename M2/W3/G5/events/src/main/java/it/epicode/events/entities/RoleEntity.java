package it.epicode.events.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "roles")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity extends BaseEntity{

    private String name;

    @ManyToMany(mappedBy = "users")
    private final List<UserEntity> users = new ArrayList<>();
}
