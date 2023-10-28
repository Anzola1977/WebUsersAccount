package com.example.WebUsersAccount.services;

import com.example.WebUsersAccount.Type_operation;
import com.example.WebUsersAccount.entities.ListOfOperations;
import com.example.WebUsersAccount.entities.Users;
import com.example.WebUsersAccount.repositories.ListOfOperationsRepository;
import com.example.WebUsersAccount.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    ListOfOperations listOfOperations;

    @Autowired
    Users users;

    @Autowired
    private UsersRepository balanceRepository;

    @Autowired
    private ListOfOperationsRepository listOfOperationsRepository;

    public Users save(Users users) {
        return balanceRepository.save(users);
    }

    public ListOfOperations save(ListOfOperations listOfOperations){
        return listOfOperationsRepository.save(listOfOperations);
    }

    public int getBalance(int id) {
        Timestamp time = Timestamp.from(Instant.now());
        users = balanceRepository.findById(id).orElseThrow();
        listOfOperations.setTimeOfOperation(time);
        listOfOperations.setType_operation(Type_operation.GET);
        listOfOperations.setUsers(balanceRepository.getReferenceById(id));
        save(listOfOperations);
        return users.getBalance();
    }

    public int putMoney(int id, int amount) {
        users = balanceRepository.findById(id).orElseThrow();
        Timestamp time = Timestamp.from(Instant.now());
        int currentBalance = users.getBalance() + amount;
        if (currentBalance > -1) {
            listOfOperations.setSumOfOperation(amount);
            listOfOperations.setTimeOfOperation(time);
            listOfOperations.setType_operation(Type_operation.PUT);
            listOfOperations.setUsers(balanceRepository.getReferenceById(id));
            users.setBalance(currentBalance);
            save(users);
            save(listOfOperations);
            return 1;
        }
        return 0;
    }

    public int takeMoney(int id, int amount) {
        Timestamp time = Timestamp.from(Instant.now());
        users = balanceRepository.findById(id).orElseThrow();
        int currentBalance = users.getBalance() - amount;
        if (currentBalance > -1) {
            users.setBalance(currentBalance);
            listOfOperations.setSumOfOperation(amount);
            listOfOperations.setTimeOfOperation(time);
            listOfOperations.setType_operation(Type_operation.TAKE);
            listOfOperations.setUsers(balanceRepository.getReferenceById(id));
            save(listOfOperations);
            save(users);
            return 1;
        }
        return 0;
    }

    public ListOfOperations getListOfOperations(Timestamp timestamp){
        listOfOperations = listOfOperationsRepository.getReferenceById(timestamp);
        return listOfOperations;
    }
}
