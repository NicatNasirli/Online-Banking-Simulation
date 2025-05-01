package test.server.business.concrates;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import test.server.business.abstracts.AccountService;

@Component
@AllArgsConstructor
public class AccountManager {
    private final AccountService accountService;

}
