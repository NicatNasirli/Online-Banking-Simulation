package test.server.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import test.server.business.concrates.AccountManager;
import test.server.dataTransferObjects.requests.CreateNewAccountRequest;

@RestController
@RequestMapping("/users/{userId}/accounts")
@AllArgsConstructor
public class AccountController {

    private final AccountManager accountManager;

    @PostMapping
    public void addAccount(@PathVariable Long userId, @RequestBody CreateNewAccountRequest createNewAccountRequest){
        this.accountManager.add(userId, createNewAccountRequest);
    }

}

