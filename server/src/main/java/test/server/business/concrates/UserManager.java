package test.server.business.concrates;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import test.server.business.abstracts.UserService;
import test.server.dataAccess.UserRepository;
import test.server.dataTransferObjects.requests.CreateAccountRequest;
import test.server.dataTransferObjects.requests.CreateUserRequest;
import test.server.dataTransferObjects.requests.LoginRequest;
import test.server.dataTransferObjects.responses.GetUserResponse;
import test.server.entities.Account;
import test.server.entities.User;
import test.server.utilities.PasswordUtil;
import test.server.utilities.exception.DataNotFoundException;
import test.server.utilities.exception.DuplicateResourceException;
import test.server.utilities.exception.InvalidCredentialsException;
import test.server.utilities.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class UserManager implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public void add(CreateUserRequest createUserRequest) {
        if (this.userRepository.existsByEmail(createUserRequest.getEmail()))
            throw new DuplicateResourceException("Email already exists!");

        User user = this.userMapper.createUserRequest(createUserRequest);
        user.setPassword(PasswordUtil.hashPassword(user.getPassword()));//hashed password

        this.userRepository.save(user);
    }

    @Override
    public GetUserResponse getById(long id) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isEmpty()) {
            throw new DataNotFoundException("User does not exists!");
        }else {
            return this.userMapper.userToDTO(user.get());
        }
    }

    @Override
    public List<GetUserResponse> getAll() {
        return this.userRepository.findAll()
                .stream()
                .map(this.userMapper::userToDTO)
                .toList();
    }

    @Override
    public boolean checkPassword(LoginRequest loginRequest) {
        Optional<User> user = this.userRepository.findByEmail(loginRequest.getEmail());
        if (user.isPresent()){
            String hashedPassword = user.get().getPassword();
            boolean checkPassword = (PasswordUtil.checkPassword(loginRequest.getPassword(),hashedPassword));

            if(!checkPassword)
                throw new InvalidCredentialsException("Wrong email or password!");
            else
                return checkPassword;

        }else
            throw new DataNotFoundException("Email does not exists!");

    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> user = this.userRepository.findByEmail(email);
        if (user.isPresent()){
            return user.get();
        }
        throw new DataNotFoundException("Email does not exist");
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isPresent()){
            return user.get();
        }else throw new DataNotFoundException("User does not exit");
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }


}
