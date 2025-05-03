package test.server.utilities.mapper;

import org.springframework.stereotype.Component;
import test.server.dataTransferObjects.requests.CreateTransactionRequest;
import test.server.entities.Account;
import test.server.entities.Transaction;

import java.time.LocalDateTime;

@Component
public class TransactionMapper {

    //DTO to Entity object

    //create new Transaction
    public Transaction createTransactionRequest(CreateTransactionRequest createTransactionRequest,
                                                Account receiverAccount, Account senderAccount){
        Transaction returnedTransaction = new Transaction();
        returnedTransaction.setAmount(createTransactionRequest.getAmount());
        returnedTransaction.setDate(LocalDateTime.now());
        returnedTransaction.setDescription(createTransactionRequest.getDescription());
        returnedTransaction.setReceiverAccount(receiverAccount);
        returnedTransaction.setSenderAccount(senderAccount);

        return returnedTransaction;
    }
}
