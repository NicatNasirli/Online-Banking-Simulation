package test.server.dataTransferObjects.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAccountResponse {

    private long id;

    private String accountNumber;

    private Double balance;

    private GetUserResponse user;

    private List<GetTransactionResponse> receivedTransactions;

    private List<GetTransactionResponse> sentTransactions;
}
