package test.server.dataTransferObjects.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTransactionResponse {
    private long id;

    private double amount;

    private LocalDateTime date;

    private String description;

    private String receiverAccountNumber;

    private String senderAccountNumber;
}
