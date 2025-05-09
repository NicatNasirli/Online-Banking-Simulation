package test.server.business.concrates;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import test.server.business.abstracts.AccountService;
import test.server.dataAccess.AccountRepository;
import test.server.dataTransferObjects.requests.CreateAccountRequest;
import test.server.entities.Account;
import test.server.utilities.CardNumberGenerator;
import test.server.utilities.exception.DataNotFoundException;
import test.server.utilities.mapper.AccountMapper;

import java.util.Optional;

@Component
@AllArgsConstructor
public class AccountManager implements AccountService{
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;


    @Override
    public void add(CreateAccountRequest createAccountRequest) {
        Account account = this.accountMapper.createAccountRequest(createAccountRequest);

        this.accountRepository.save(account);
    }

    @Override
    public void add(Account account) {

        this.accountRepository.save(account);
    }

    @Override
    public String generateCardNumber() {
        return CardNumberGenerator.generateCardNumber();
    }

    @Override
    public Account getByCardNumber(String accountNumber) {
        Optional<Account> account = this.accountRepository.findByAccountNumber(accountNumber);
        if (account.isPresent())
            return account.get();
        else
            throw new DataNotFoundException("Account does not exists!");
    }
}
