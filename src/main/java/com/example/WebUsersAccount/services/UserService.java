package com.example.WebUsersAccount.services;

import com.example.WebUsersAccount.entities.Operations;
import com.example.WebUsersAccount.entities.Users;
import com.example.WebUsersAccount.repositories.OperationsRepository;
import com.example.WebUsersAccount.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    List<Operations> operationsList = new ArrayList<>();

    @Autowired
    private UsersRepository balanceRepository;

    @Autowired
    private OperationsRepository operationsRepository;

    public Users save(Users users) {
        return balanceRepository.save(users);
    }

    public Operations save(Operations operations){
        return operationsRepository.save(operations);
    }

    public int getBalance(int id) {
        LocalDateTime time = LocalDateTime.now();
        Users users = balanceRepository.findById(id).orElseThrow();
        Operations operations = new Operations();
        operations.setTimeOfOperation(time);
        operations.setType_operation("GET BALANCE");
        operations.setUsers(balanceRepository.getReferenceById(id));
        operationsList.add(operations);
        save(operations);
        return users.getBalance();
    }

    public int putMoney(int id, int amount) {
        Users users = balanceRepository.findById(id).orElseThrow();
        LocalDateTime time = LocalDateTime.now();
        Operations operations = new Operations();
        int currentBalance = users.getBalance() + amount;
        if (currentBalance > -1) {
            operations.setSumOfOperation(amount);
            operations.setTimeOfOperation(time);
            operations.setType_operation("PUT MONEY");
            operations.setUsers(balanceRepository.getReferenceById(id));
            users.setBalance(currentBalance);
            operationsList.add(operations);
            save(users);
            save(operations);
            return 1;
        }
        return 0;
    }

    public int takeMoney(int id, int amount) {
        LocalDateTime time = LocalDateTime.now();
        Users users = balanceRepository.findById(id).orElseThrow();
        Operations operations = new Operations();
        int currentBalance = users.getBalance() - amount;
        if (currentBalance > -1) {
            users.setBalance(currentBalance);
            operations.setSumOfOperation(amount);
            operations.setTimeOfOperation(time);
            operations.setType_operation("TAKE MONEY");
            operations.setUsers(balanceRepository.getReferenceById(id));
            operationsList.add(operations);
            save(operations);
            save(users);
            return 1;
        }
        return 0;
    }

    public List<Operations> getListOfOperationsCertainTime(LocalDateTime timeOfOperationStart, LocalDateTime timeOfOperationEnd){
        operationsList = operationsRepository.findByTimeOfOperationBetween(timeOfOperationStart, timeOfOperationEnd);
        return operationsList;
    }

    public List<Operations> getListOfOperationsAllTime() {
        return operationsRepository.findByUsers_OperationsList_TimeOfOperationLessThan(LocalDateTime.now());
    }
}
