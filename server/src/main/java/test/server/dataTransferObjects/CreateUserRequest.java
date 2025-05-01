package test.server.dataTransferObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import test.server.entities.Account;
import test.server.entities.enums.Role;

@Data
@AllArgsConstructor
public class CreateUserRequest {

    private String name;

    private String surname;

    private String email;

    private Role role;

    private boolean isBlocked;

    private Account account;

}