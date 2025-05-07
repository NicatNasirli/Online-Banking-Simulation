package test.server.utilities.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import test.server.dataTransferObjects.requests.CreateAccountRequest;
import test.server.dataTransferObjects.responses.GetAccountResponse;
import test.server.entities.Account;


@AllArgsConstructor
@Component
public class AccountMapper extends Mapper{

    private final TransactionMapper transactionMapper;

    //DTO to Entity object

    //create new account
    public Account createAccountRequest(CreateAccountRequest createAccountRequest){
        Account returnedAccount = new Account();
        returnedAccount.setAccountNumber(createAccountRequest.getAccountNumber());
        returnedAccount.setBalance(createAccountRequest.getBalance());
        returnedAccount.setReceivedTransactions(null);
        returnedAccount.setSentTransactions(null);
        returnedAccount.setUser(createAccountRequest.getUser());

        return returnedAccount;
    }

    //Account object to DTO

    //get account
    public GetAccountResponse accountToDTO(Account account){
        GetAccountResponse response = new GetAccountResponse();

        response.setAccountNumber(account.getAccountNumber());
        response.setBalance(account.getBalance());
        response.setId(account.getId());

        response.setReceivedTransactions(account.getReceivedTransactions().stream().map(this.transactionMapper::transactionToDTO).toList());
        response.setSentTransactions(account.getSentTransactions().stream().map(this.transactionMapper::transactionToDTO).toList());
        return response;
    }
}
