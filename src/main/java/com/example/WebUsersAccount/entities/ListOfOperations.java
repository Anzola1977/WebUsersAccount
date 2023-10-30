package com.example.WebUsersAccount.entities;

import com.example.WebUsersAccount.Type_operation;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Component
@Table(name = "list_of_operations")
public class ListOfOperations {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_operation")
        private int idOperation;

        @OneToOne(cascade = {CascadeType.ALL})
        @JoinColumn(name = "users_account_id", referencedColumnName = "id")
        private Users users;

        @Column(name = "type_operation")
        private String Type_operation;

        @Column(name = "timeOfOperation")
        private LocalDateTime timeOfOperation;

        @Column(name = "sum_operation")
        private int sumOfOperation;
}
