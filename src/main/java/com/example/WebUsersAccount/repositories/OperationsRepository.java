package com.example.WebUsersAccount.repositories;

import com.example.WebUsersAccount.entities.Operations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OperationsRepository extends JpaRepository<Operations, Integer> {
    List<Operations> findByUsers_OperationsList_TimeOfOperationLessThan(LocalDateTime timeOfOperation);
    List<Operations> findByTimeOfOperationBetween(LocalDateTime timeOfOperationStart, LocalDateTime timeOfOperationEnd);

}