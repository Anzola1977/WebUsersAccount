package com.example.WebUsersAccount.controllers;

import com.example.WebUsersAccount.entities.Operations;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.WebUsersAccount.services.UserService;
import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/list_of_operations")
@RestController
@RequiredArgsConstructor
public class OperationController {

    private final UserService Service;

    @GetMapping("/getListOfOperationsCertainTime/{timeOfOperations}")
    public List<Operations> getListOfOperationsCertainTime(@RequestParam LocalDateTime timeOfOperationStart, @RequestParam LocalDateTime timeOfOperationEnd) {
        return Service.getListOfOperationsCertainTime(timeOfOperationStart, timeOfOperationEnd);
    }

    @GetMapping("/getListOfOperationsAllTime")
    public List<Operations> getListOfOperationsAllTime() {
        return Service.getListOfOperationsAllTime();
    }
}
