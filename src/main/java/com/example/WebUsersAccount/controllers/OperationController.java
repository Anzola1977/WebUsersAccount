package com.example.WebUsersAccount.controllers;

import com.example.WebUsersAccount.entities.ListOfOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.WebUsersAccount.services.UserService;

import java.sql.Timestamp;

@RequestMapping("/list_of_operations")
@RestController
@RequiredArgsConstructor
public class OperationController {

    private final UserService Service;

    @GetMapping("/getListOfOperations/{timeOfOperation}")
    public ListOfOperations getListOfOperations(@RequestParam Timestamp timeOfOperation) {
        return Service.getListOfOperations(timeOfOperation);
    }
}
