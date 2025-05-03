package test.server.business.concrates;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import test.server.business.abstracts.TransactionService;
import test.server.dataAccess.TransactionRepository;
import test.server.dataTransferObjects.requests.CreateTransactionRequest;
import test.server.entities.Account;
import test.server.entities.Transaction;
import test.server.utilities.mapper.TransactionMapper;

@AllArgsConstructor
@Component
public class BankTransactionManager implements TransactionService {

    private final TransactionMapper transactionMapper;
    private final TransactionRepository transactionRepository;
    private final AccountManager accountManager;

    @Override
    public void addTransaction(CreateTransactionRequest createTransactionRequest) {
        double amount = createTransactionRequest.getAmount();
        Account sender = this.accountManager.getAccountByNumber(createTransactionRequest.getSenderAccountNumber());
        sender.setBalance(sender.getBalance() - amount);
        Account receiver = this.accountManager.getAccountByNumber(createTransactionRequest.getReceiverAccountNumber());
        receiver.setBalance(receiver.getBalance() + amount);
        Transaction transaction = this.transactionMapper.
                createTransactionRequest(createTransactionRequest, receiver, sender);

        this.transactionRepository.save(transaction);
    }

}
