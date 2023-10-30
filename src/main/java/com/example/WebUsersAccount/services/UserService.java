package com.example.WebUsersAccount.services;

import com.example.WebUsersAccount.Type_operation;
import com.example.WebUsersAccount.entities.ListOfOperations;
import com.example.WebUsersAccount.entities.Users;
import com.example.WebUsersAccount.repositories.ListOfOperationsRepository;
import com.example.WebUsersAccount.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    ListOfOperations listOfOperations;

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
        LocalDateTime time = LocalDateTime.now();
        Users users = balanceRepository.findById(id).orElseThrow();
        listOfOperations.setTimeOfOperation(time);
        listOfOperations.setType_operation("GET BALANCE");
        listOfOperations.setUsers(balanceRepository.getReferenceById(id));
        save(listOfOperations);
        return users.getBalance();
    }

    public int putMoney(int id, int amount) {
        Users users = balanceRepository.findById(id).orElseThrow();
        LocalDateTime time = LocalDateTime.now();
        int currentBalance = users.getBalance() + amount;
        if (currentBalance > -1) {
            listOfOperations.setSumOfOperation(amount);
            listOfOperations.setTimeOfOperation(time);
            listOfOperations.setType_operation("PUT MONEY");
            listOfOperations.setUsers(balanceRepository.getReferenceById(id));
            users.setBalance(currentBalance);
            save(users);
            save(listOfOperations);
            return 1;
        }
        return 0;
    }

    public int takeMoney(int id, int amount) {
        LocalDateTime time = LocalDateTime.now();
        Users users = balanceRepository.findById(id).orElseThrow();
        int currentBalance = users.getBalance() - amount;
        if (currentBalance > -1) {
            users.setBalance(currentBalance);
            listOfOperations.setSumOfOperation(amount);
            listOfOperations.setTimeOfOperation(time);
            listOfOperations.setType_operation("TAKE MONEY");
            listOfOperations.setUsers(balanceRepository.getReferenceById(id));
            save(listOfOperations);
            save(users);
            return 1;
        }
        return 0;
    }

    public ListOfOperations getListOfOperationsCertainTime(LocalDate timeOfOperationStart, LocalDate timeOfOperationEnd){
        Period time = Period.between(timeOfOperationStart, timeOfOperationEnd);
        listOfOperations = listOfOperationsRepository.getReferenceById(time);
        return listOfOperations;
    }

    public ListOfOperations getListOfOperationsAllTime(){

        Period time =  Period.between(LocalDate.EPOCH, LocalDate.now());
        //listOfOperations.getTimeOfOperation().)
        listOfOperations = listOfOperationsRepository.getReferenceById(time);////
        return listOfOperations;
    }
}
