package test.server.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import test.server.business.concrates.BankTransactionManager;
import test.server.dataTransferObjects.requests.CreateTransactionRequest;

@AllArgsConstructor
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final BankTransactionManager transactionManager;

    @PostMapping("/{fromId}/{toId}")
    public void transferMoney(
            @PathVariable Long fromId,
            @PathVariable Long toId,
            @RequestBody CreateTransactionRequest createTransactionRequest) {

        this.transactionManager.add(fromId,toId, createTransactionRequest);
    }

}
