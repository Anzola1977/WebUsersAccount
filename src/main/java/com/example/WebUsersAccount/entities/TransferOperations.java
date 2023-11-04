package com.example.WebUsersAccount.entities;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.stereotype.Component;


@Getter
@Entity
@Component
@Table(name = "transfer_operations")
public class TransferOperations {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

}
