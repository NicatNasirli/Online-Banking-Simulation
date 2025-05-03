package test.server.dataTransferObjects.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import test.server.entities.User;

@Data
@AllArgsConstructor
public class CreateAccountRequest {

    private String accountNumber;

    private Double balance;

    private User user;

}
