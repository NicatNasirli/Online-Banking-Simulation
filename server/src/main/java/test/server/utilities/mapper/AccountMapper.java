package test.server.utilities.mapper;

import org.springframework.stereotype.Component;
import test.server.dataTransferObjects.requests.CreateAccountRequest;
import test.server.entities.Account;

@Component
public class AccountMapper {

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
}
