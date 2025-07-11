package test.server.dataTransferObjects.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.server.entities.enums.Role;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponse {
    private long id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private Role role;

    private boolean isBlocked;

    private List<GetAccountResponse> accounts;
}
