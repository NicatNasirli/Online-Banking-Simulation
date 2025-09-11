package test.server.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import test.server.business.concrates.AccountManager;
import test.server.dataTransferObjects.requests.CreateNewAccountRequest;

@RestController
@RequestMapping("/users/{userId}/accounts")
@AllArgsConstructor
@Tag(name = "Accounts", description = "Operations related to bank accounts")
public class AccountController {

    private final AccountManager accountManager;

    @PostMapping
    @Operation(summary = "Create new account", description = "Registers a new account in the system")
    public void addAccount(@PathVariable Long userId, @RequestBody CreateNewAccountRequest createNewAccountRequest){
        this.accountManager.add(userId, createNewAccountRequest);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete account by id", description = "Delete a account")
    public void deleteAccount(@PathVariable Long id){
        this.accountManager.deleteAccount(id);
    }
}

