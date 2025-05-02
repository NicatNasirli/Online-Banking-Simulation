package test.server.business.abstracts;

import org.springframework.stereotype.Service;
import test.server.dataTransferObjects.CreateUserRequest;

@Service
public interface UserService {
    void addUser(CreateUserRequest createUserRequest);
}
