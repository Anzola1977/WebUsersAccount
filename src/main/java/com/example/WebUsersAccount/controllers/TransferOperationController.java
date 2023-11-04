package com.example.WebUsersAccount.controllers;

import com.example.WebUsersAccount.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/list_of_transferOperations")
@RestController
@RequiredArgsConstructor
public class TransferOperationController {

        private final UserService Service;

        @PutMapping("/transferMoney")
        public void transferMoney(@RequestParam int idSender, @RequestParam int idRecipient, @RequestParam int amount) {
            Service.transferMoney(idRecipient, idSender, amount);
        }
}
