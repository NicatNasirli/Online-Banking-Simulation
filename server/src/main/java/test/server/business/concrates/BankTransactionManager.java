package test.server.business.concrates;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import test.server.business.abstracts.TransactionService;
import test.server.dataAccess.TransactionRepository;
import test.server.utilities.mapper.TransactionMapper;

@AllArgsConstructor
@Component
public class BankTransactionManager implements TransactionService {

    private final TransactionMapper transactionMapper;
    private final TransactionRepository transactionRepository;

}
