package test.server.dataTransferObjects.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import test.server.entities.Account;

@Data
@AllArgsConstructor
public class CreateUserRequest {

    private String name;

    private String surname;

    private String email;

    private boolean isBlocked;

    private Account account;

}