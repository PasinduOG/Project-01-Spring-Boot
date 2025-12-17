package com.example.controller;

import com.example.dto.ApiResponse;
import com.example.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private final List<User> userList = new ArrayList<>();

    @GetMapping
    public String getWelcomeMessage(){
        return "Welcome to User Management System";
    }

    @GetMapping("/get-all-users")
    public List<User> getUserList(){
        return userList;
    }

    @PostMapping("/add-user")
    public ResponseEntity<ApiResponse<User>> addNewUser(@RequestBody User user){
        userList.add(user);

        ApiResponse<User> response = new ApiResponse<>(
                "success",
                "User registered successfully",
                user
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
