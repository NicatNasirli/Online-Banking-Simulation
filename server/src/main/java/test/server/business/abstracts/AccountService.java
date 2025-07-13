package test.server.business.abstracts;

import org.springframework.stereotype.Service;
import test.server.dataTransferObjects.requests.CreateNewAccountRequest;
import test.server.entities.Account;

@Service
public interface AccountService {
    void add(Long userId,CreateNewAccountRequest createNewAccountRequest);
    void add(Account account);
    String generateCardNumber();
    Account getByCardNumber(String accountNumber);
    Account getAccountById(Long id);
    void deleteAccount(Long id);

}
