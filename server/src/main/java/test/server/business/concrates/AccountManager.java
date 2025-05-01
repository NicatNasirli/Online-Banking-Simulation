package test.server.business.concrates;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import test.server.business.abstracts.AccountService;
import test.server.dataAccess.AccountRepository;
import test.server.dataTransferObjects.CreateAccountRequest;
import test.server.entities.Account;
import test.server.utilities.mapper.AccountMapper;

@Component
@AllArgsConstructor
public class AccountManager implements AccountService{
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;


    @Override
    public void createAccount(CreateAccountRequest createAccountRequest) {
        Account account = this.accountMapper.createAccountRequest(createAccountRequest);

        this.accountRepository.save(account);
    }
}
