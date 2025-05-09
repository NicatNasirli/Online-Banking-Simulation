package test.server.business.abstracts;

import org.springframework.stereotype.Service;
import test.server.dataTransferObjects.requests.CreateUserRequest;
import test.server.dataTransferObjects.responses.GetUserResponse;

import java.util.List;

@Service
public interface UserService {
    void add(CreateUserRequest createUserRequest);
    GetUserResponse getById(long id);
    List<GetUserResponse> getAll();
    boolean checkPassword(String password, String email);
}
