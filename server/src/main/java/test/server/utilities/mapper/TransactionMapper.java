package test.server.utilities.mapper;

import org.springframework.stereotype.Component;
import test.server.dataTransferObjects.CreateTransactionRequest;
import test.server.entities.Transaction;

@Component
public class TransactionMapper {

    //DTO to Entity object

    //create new Transaction
    public Transaction createTransactionRequest(CreateTransactionRequest createTransactionRequest){
        Transaction returnedTransaction = new Transaction();
        returnedTransaction.setAmount(createTransactionRequest.getAmount());
        returnedTransaction.setDate(createTransactionRequest.getDate());
        returnedTransaction.setDescription(createTransactionRequest.getDescription());
        returnedTransaction.setReceiverAccount(createTransactionRequest.getReceiverAccount());
        returnedTransaction.setSenderAccount(createTransactionRequest.getSenderAccount());

        return returnedTransaction;
    }
}
