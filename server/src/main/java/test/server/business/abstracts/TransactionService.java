package test.server.business.abstracts;

import org.springframework.stereotype.Service;
import test.server.dataTransferObjects.requests.CreateTransactionRequest;

@Service
public interface TransactionService {
    void add(CreateTransactionRequest createTransactionRequest);
    boolean canSendMoney(CreateTransactionRequest createTransactionRequest);
}
