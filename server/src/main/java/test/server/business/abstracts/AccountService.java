package test.server.business.abstracts;

import org.springframework.stereotype.Service;
import test.server.dataTransferObjects.CreateAccountRequest;

@Service
public interface AccountService {
    void createAccount(CreateAccountRequest createAccountRequest);
}
