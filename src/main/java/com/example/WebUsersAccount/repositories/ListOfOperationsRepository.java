package com.example.WebUsersAccount.repositories;

import com.example.WebUsersAccount.entities.ListOfOperations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Period;

@Repository
public interface ListOfOperationsRepository extends JpaRepository<ListOfOperations, Period> {
}