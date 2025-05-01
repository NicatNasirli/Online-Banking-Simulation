package test.server.utilities.mapper;

import org.springframework.stereotype.Component;
import test.server.dataTransferObjects.CreateUserRequest;
import test.server.entities.User;

@Component
public class UserMapper {

    //DTO to Entity object

    //create new User
    public User createUserRequest(CreateUserRequest createUserRequest){
        User returnedUser = new User();
        returnedUser.setAccount(createUserRequest.getAccount());
        returnedUser.setBlocked(createUserRequest.isBlocked());
        returnedUser.setEmail(createUserRequest.getEmail());
        returnedUser.setName(createUserRequest.getName());
        returnedUser.setSurname(createUserRequest.getSurname());
        returnedUser.setRole(createUserRequest.getRole());

        return returnedUser;
    }
}
