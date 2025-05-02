package test.server.business.abstracts;

import org.springframework.stereotype.Service;
import test.server.dataTransferObjects.CreateAccountRequest;
import test.server.entities.Account;

@Service
public interface AccountService {
    void addAccount(CreateAccountRequest createAccountRequest);
    void addAccount(Account account);
    String generateCardNumber();
}
