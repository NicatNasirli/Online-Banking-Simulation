package test.server.business.concrates;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import test.server.business.abstracts.UserService;
import test.server.dataAccess.UserRepository;
import test.server.utilities.mapper.UserMapper;

@AllArgsConstructor
@Component
public class UserManager implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;


}
