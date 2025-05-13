package test.server.business.concrates;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import test.server.business.abstracts.TransactionService;
import test.server.dataAccess.TransactionRepository;
import test.server.dataTransferObjects.requests.CreateTransactionRequest;
import test.server.entities.Account;
import test.server.entities.Transaction;
import test.server.utilities.email.EmailSender;
import test.server.utilities.exception.InsufficientBalanceException;
import test.server.utilities.mapper.TransactionMapper;

@AllArgsConstructor
@Component
public class BankTransactionManager implements TransactionService {

    private final TransactionMapper transactionMapper;
    private final TransactionRepository transactionRepository;
    private final AccountManager accountManager;

    @Override
    public void add(CreateTransactionRequest createTransactionRequest) {
        if(canSendMoney(createTransactionRequest)){

            double amount = createTransactionRequest.getAmount();
            //Sender's account number
            Account sender = this.accountManager.
                    getByCardNumber(createTransactionRequest.getSenderAccountNumber());
            sender.setBalance(sender.getBalance() - amount);

            //Receiver's account number
            Account receiver = this.accountManager.
                    getByCardNumber(createTransactionRequest.getReceiverAccountNumber());
            receiver.setBalance(receiver.getBalance() + amount);

            Transaction transaction = this.transactionMapper.
                    createTransactionRequest(createTransactionRequest, receiver, sender);

            //Send email
            EmailSender.sendEmail(receiver.getUser().getEmail(),
                    "Money Receive Transaction",
                    transaction.getDescription());

            EmailSender.sendEmail(sender.getUser().getEmail(),
                    "Money Send Transaction",
                    transaction.getDescription());

            this.transactionRepository.save(transaction);
        }
    }

    @Override
    public boolean canSendMoney(CreateTransactionRequest createTransactionRequest) {
        Account account = this.accountManager
                .getByCardNumber(createTransactionRequest.getSenderAccountNumber());
        if (account.getBalance() - createTransactionRequest.getAmount() < 0)
            throw new InsufficientBalanceException("There is no enough balance!");

        return true;
    }
}
