package com.example.WebUsersAccount.repositories;

import com.example.WebUsersAccount.entities.TransferOperations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferOperationsRepository extends JpaRepository <TransferOperations, Integer> {
}
