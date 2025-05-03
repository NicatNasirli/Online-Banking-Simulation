package test.server.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.server.business.concrates.AccountManager;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    private final AccountManager accountManager;

}
