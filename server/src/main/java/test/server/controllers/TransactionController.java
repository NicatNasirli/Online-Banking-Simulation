package test.server.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import test.server.business.concrates.BankTransactionManager;
import test.server.dataTransferObjects.requests.CreateTransactionRequest;

@AllArgsConstructor
@RestController
@RequestMapping("/transactions")
@Tag(name = "Transactions", description = "Operations related to bank transactions")
public class TransactionController {

    private final BankTransactionManager transactionManager;

    @PostMapping("/{fromId}/{toId}")
    @Operation(summary = "Transfer money", description = "Transfer money from sender_id to receiver_id")
    public void transferMoney(
            @PathVariable Long fromId,
            @PathVariable Long toId,
            @RequestBody CreateTransactionRequest createTransactionRequest) {

        this.transactionManager.add(fromId,toId, createTransactionRequest);
    }

}
