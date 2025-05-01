package test.server.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.server.entities.enums.Role;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String surname;

    @Column(nullable = false, unique = true)
    private String email;

    private Role role;

    private boolean isBlocked;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Account account;

}
