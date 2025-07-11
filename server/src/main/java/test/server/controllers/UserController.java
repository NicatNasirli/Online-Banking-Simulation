package test.server.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import test.server.business.concrates.UserManager;
import test.server.dataTransferObjects.requests.CreateUserRequest;
import test.server.dataTransferObjects.responses.GetUserResponse;

import java.util.List;

@RestController
@RequestMapping( "/users")
@AllArgsConstructor
public class UserController {
    private final UserManager userManager;

    @PostMapping
    public void addUser(@RequestBody CreateUserRequest createUserRequest){

        this.userManager.add(createUserRequest);
    }

    @GetMapping("/{id}")
    public GetUserResponse getUserResponseById(@PathVariable long id){
        return this.userManager.getById(id);
    }

    @GetMapping("/getAll")
    public List<GetUserResponse> getAllUser(){
        return this.userManager.getAll();
    }


}
