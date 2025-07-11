package test.server.business.concrates;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import test.server.business.abstracts.AccountService;
import test.server.dataAccess.AccountRepository;
import test.server.dataTransferObjects.requests.CreateNewAccountRequest;
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
    private final UserManager userManager;


    @Override
    public void add(Long userId, CreateNewAccountRequest createNewAccountRequest) {
        Account account = new Account();
        account.setAccountNumber(this.generateCardNumber());
        account.setUser(this.userManager.getUserById(userId));
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

    @Override
    public Account getAccountById(Long id) {
        Optional<Account> account = this.accountRepository.findById(id);
        if (account.isPresent()){
            return account.get();
        }else throw new DataNotFoundException("Account does not exist");
    }
}
