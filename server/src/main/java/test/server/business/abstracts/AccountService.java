package test.server.business.abstracts;

import org.springframework.stereotype.Service;
import test.server.dataTransferObjects.requests.CreateAccountRequest;
import test.server.entities.Account;

@Service
public interface AccountService {
    void add(CreateAccountRequest createAccountRequest);
    void add(Account account);
    String generateCardNumber();
    Account getByCardNumber(String accountNumber);

}
