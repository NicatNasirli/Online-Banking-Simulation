package test.server.business.concrates;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import test.server.business.abstracts.AccountService;
import test.server.dataAccess.AccountRepository;
import test.server.dataTransferObjects.CreateAccountRequest;
import test.server.entities.Account;
import test.server.utilities.CardNumberGenerator;
import test.server.utilities.mapper.AccountMapper;

@Component
@AllArgsConstructor
public class AccountManager implements AccountService{
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;


    @Override
    public void addAccount(CreateAccountRequest createAccountRequest) {
        Account account = this.accountMapper.createAccountRequest(createAccountRequest);

        this.accountRepository.save(account);
    }

    @Override
    public void addAccount(Account account) {

        this.accountRepository.save(account);
    }

    @Override
    public String generateCardNumber() {
        return CardNumberGenerator.generateCardNumber();
    }
}
