package com.example.WebUsersAccount;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController("/users")
@RequiredArgsConstructor
public class Controller {

    private final Service Service;

    @GetMapping("/getbalance/{id}")
    public int getBalance(@PathVariable int id) {
        return Service.getBalance(id);
    }

    @PutMapping("/putMoney")
    public void putMoney(@RequestParam int id, @RequestParam int amount) {
        Service.putMoney(id, amount);
    }

    @PutMapping("/takeMoney")
    public void takeMoney(@RequestParam int id, @RequestParam int amount) {
        Service.takeMoney(id, amount);

    }
}

