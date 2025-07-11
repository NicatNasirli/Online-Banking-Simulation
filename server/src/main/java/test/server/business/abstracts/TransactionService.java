package test.server.business.abstracts;

import org.springframework.stereotype.Service;
import test.server.dataTransferObjects.requests.CreateTransactionRequest;

@Service
public interface TransactionService {
    void add(Long senderAccountId,Long receiverAccountId, CreateTransactionRequest createTransactionRequest);
    boolean canSendMoney(Long id, CreateTransactionRequest createTransactionRequest);

}
