package test.server.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.server.business.concrates.BankTransactionManager;
import test.server.dataTransferObjects.requests.CreateTransactionRequest;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    private final BankTransactionManager transactionManager;

    @PostMapping
    public void addTransaction(@RequestBody CreateTransactionRequest createTransactionRequest){
        this.transactionManager.addTransaction(createTransactionRequest);
    }
}
