package test.server.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.server.business.concrates.UserManager;
import test.server.dataTransferObjects.CreateUserRequest;

@RestController
@RequestMapping(value = "/user")
@AllArgsConstructor
public class UserController {
    private final UserManager userManager;

    @PostMapping
    public void addUser(@RequestBody CreateUserRequest createUserRequest){

        this.userManager.addUser(createUserRequest);
    }
}
