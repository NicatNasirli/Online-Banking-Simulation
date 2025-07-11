package test.server.utilities.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import test.server.dataTransferObjects.requests.CreateUserRequest;
import test.server.dataTransferObjects.responses.GetUserResponse;
import test.server.entities.User;
import test.server.entities.enums.Role;

@AllArgsConstructor
@Component
public class UserMapper extends Mapper {

    private final AccountMapper accountMapper;

    //DTO to Entity object

    //create new User
    public User createUserRequest(CreateUserRequest createUserRequest){
        User returnedUser = new User();
        returnedUser.setAccounts(null);
        returnedUser.setBlocked(createUserRequest.isBlocked());
        returnedUser.setEmail(createUserRequest.getEmail());
        returnedUser.setPassword(createUserRequest.getPassword());
        returnedUser.setName(createUserRequest.getName());
        returnedUser.setSurname(createUserRequest.getSurname());
        returnedUser.setRole(Role.USER);

        return returnedUser;
    }

    //Entity object to DTO

    //get userResponse
    public GetUserResponse userToDTO(User user){
        GetUserResponse userResponse = new GetUserResponse();

        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setSurname(user.getSurname());
        userResponse.setBlocked(user.isBlocked());
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setRole(user.getRole());
        userResponse.setAccounts(user
                .getAccounts()
                .stream()
                .map(this.accountMapper::accountToDTO)
                .toList());

        return userResponse;
    }
}
