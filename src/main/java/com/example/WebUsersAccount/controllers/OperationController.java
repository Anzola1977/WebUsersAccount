package com.example.WebUsersAccount.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.WebUsersAccount.services.UserService;

@RequestMapping("/list_of_operations")
@RestController
@RequiredArgsConstructor
public class OperationController {
    private final UserService Service;

    @GetMapping("/getBalance/{id}")
    public int getBalance(@PathVariable int id) {
        return Service.getBalance(id);
    }

    @PutMapping("/putMoney")
    public void putMoney(@RequestParam int id, @RequestParam int amount) {
        Service.putMoney(id, amount);
    }

}
