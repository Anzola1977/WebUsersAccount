package controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import services.UserService;


@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService Service;

    @GetMapping("/getBalance/{id}")
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
