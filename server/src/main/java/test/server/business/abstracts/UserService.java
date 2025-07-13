package test.server.business.abstracts;

import org.springframework.stereotype.Service;
import test.server.dataTransferObjects.requests.CreateUserRequest;
import test.server.dataTransferObjects.requests.LoginRequest;
import test.server.dataTransferObjects.responses.GetUserResponse;
import test.server.entities.User;

import java.util.List;

@Service
public interface UserService {
    void add(CreateUserRequest createUserRequest);
    GetUserResponse getById(long id);
    List<GetUserResponse> getAll();
    boolean checkPassword(LoginRequest loginRequest);
    User getUserByEmail(String email);
    User getUserById(Long id);
    void deleteUser(Long id);
}
