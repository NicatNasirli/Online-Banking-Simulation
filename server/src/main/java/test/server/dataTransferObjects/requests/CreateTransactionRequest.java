package test.server.dataTransferObjects.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import test.server.entities.Account;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CreateTransactionRequest {

    private double amount;

    private LocalDateTime date;

    private String description;

    private String receiverAccountNumber;

    private String senderAccountNumber;
}

