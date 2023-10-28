package com.example.WebUsersAccount.repositories;

import com.example.WebUsersAccount.entities.ListOfOperations;
import com.example.WebUsersAccount.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface ListOfOperationsRepository extends JpaRepository<ListOfOperations, Timestamp> {
//    List<Operation> findByUserIdAndDateBetween(Long userId, LocalDate dateStart, LocalDate dateEnd);
//    List<Operation> findByUserId(Long userId);
//    List<Operation> findByUserIdAndDateAfter(Long userId, LocalDate date);
//    List<Operation> findByUserIdAndDateBefore(Long userId, LocalDate date);

}