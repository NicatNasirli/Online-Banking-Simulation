package test.server.business.concrates;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import test.server.business.abstracts.UserService;
import test.server.dataAccess.UserRepository;
import test.server.dataTransferObjects.requests.CreateUserRequest;
import test.server.dataTransferObjects.responses.GetUserResponse;
import test.server.entities.Account;
import test.server.entities.User;
import test.server.utilities.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class UserManager implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final AccountManager accountManager;

    @Transactional
    @Override
    public void add(CreateUserRequest createUserRequest) {
        User user = this.userMapper.createUserRequest(createUserRequest);
        Account account = new Account();

        //account details
        account.setAccountNumber(this.accountManager.generateCardNumber());
        account.setBalance(0.0);
        account.setReceivedTransactions(new ArrayList<>());
        account.setSentTransactions(new ArrayList<>());
        account.setUser(user);

        this.accountManager.add(account);
        this.userRepository.save(user);
    }

    @Override
    public GetUserResponse getById(long id) {
        Optional<User> user = this.userRepository.findById(id);
        //exception handling will be implemented
        GetUserResponse response = this.userMapper.userToDTO(user.get());

        return response;
    }

    @Override
    public List<GetUserResponse> getAll() {
        return this.userRepository.findAll()
                .stream()
                .map(this.userMapper::userToDTO)
                .toList();
    }
}
