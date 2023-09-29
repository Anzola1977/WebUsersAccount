package com.example.WebUsersAccount;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {

    @Autowired
    private UsersRepository balanceRepository;


    public Users save(Users users) {
        return balanceRepository.save(users);
    }

    public int getBalance(int id){
        Users users = balanceRepository.findById(id).orElseThrow();
        return users.getCurrentBalance();
    }

    public int putMoney(int id, int balance) {
        Users users = balanceRepository.findById(id).orElseThrow();
        int currentBalance = users.getCurrentBalance() + balance;
        if (currentBalance > -1) {
            users.setCurrentBalance(currentBalance);
            save(users);
            //успех
            return 1;
        }
        //ошибка при выполнении операции
        return 0;

    }

    public int takeMoney(int id, int balance) {
        Users users = balanceRepository.findById(id).orElseThrow();
        int currentBalance = users.getCurrentBalance() - balance;
        if (currentBalance > -1) {
            users.setCurrentBalance(currentBalance);
            save(users);
            //успех
            return 1;
        }
        //недостаточно средств
        return 0;
    }
}
