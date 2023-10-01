package services;

import entities.Users;
import repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UsersRepository balanceRepository;


    public Users save(Users users) {
        return balanceRepository.save(users);
    }

    public int getBalance(int id) {
        Users users = balanceRepository.findById(id).orElseThrow();
        return users.getBalance();
    }

    public int putMoney(int id, int balance) {
        Users users = balanceRepository.findById(id).orElseThrow();
        int currentBalance = users.getBalance() + balance;
        if (currentBalance > -1) {
            users.setBalance(currentBalance);
            save(users);
            return 1;
        }
        return 0;
    }

    public int takeMoney(int id, int balance) {
        Users users = balanceRepository.findById(id).orElseThrow();
        int currentBalance = users.getBalance() - balance;
        if (currentBalance > -1) {
            users.setBalance(currentBalance);
            save(users);
            return 1;
        }
        return 0;
    }
}
