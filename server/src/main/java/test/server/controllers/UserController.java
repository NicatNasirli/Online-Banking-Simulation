package test.server.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import test.server.business.concrates.UserManager;
import test.server.dataTransferObjects.requests.CreateUserRequest;
import test.server.dataTransferObjects.responses.GetUserResponse;

import java.util.List;

@RestController
@RequestMapping( "/users")
@AllArgsConstructor
@Tag(name = "Users", description = "Operations related to bank users")
public class UserController {
    private final UserManager userManager;

    @PostMapping
    @Operation(summary = "Create new user", description = "Registers a new user in the system")
    public void addUser(@RequestBody CreateUserRequest createUserRequest){

        this.userManager.add(createUserRequest);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by id", description = "Retrieve a user")
    public GetUserResponse getUserResponseById(@PathVariable long id){
        return this.userManager.getById(id);
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all users", description = "Retrieve users")
    public List<GetUserResponse> getAllUser(){
        return this.userManager.getAll();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by id", description = "Delete a user")
    public void deleteUser(@PathVariable Long id){
        this.userManager.deleteUser(id);
    }

}
