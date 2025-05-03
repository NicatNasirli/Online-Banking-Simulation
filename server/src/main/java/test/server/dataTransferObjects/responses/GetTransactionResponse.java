package test.server.dataTransferObjects.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.server.entities.Account;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTransactionResponse {
    private long id;

    private double amount;

    private LocalDateTime date;

    private String description;

    private Account receiverAccount;

    private Account senderAccount;
}
