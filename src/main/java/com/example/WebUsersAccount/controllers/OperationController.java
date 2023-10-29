package com.example.WebUsersAccount.controllers;

import com.example.WebUsersAccount.entities.ListOfOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.WebUsersAccount.services.UserService;

import java.time.LocalDate;

@RequestMapping("/list_of_operations")
@RestController
@RequiredArgsConstructor
public class OperationController {

    private final UserService Service;

    @GetMapping("/getListOfOperationsCertainTime/{timeOfOperations}")
    public ListOfOperations getListOfOperationsCertainTime(@RequestParam LocalDate timeOfOperationStart, @RequestParam LocalDate timeOfOperationEnd) {
        return Service.getListOfOperationsCertainTime(timeOfOperationStart, timeOfOperationEnd);
    }

    @GetMapping("/getListOfOperationsAllTime")
    public ListOfOperations getListOfOperationsAllTime() {
        return Service.getListOfOperationsAllTime();
    }
}
