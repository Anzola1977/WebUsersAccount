package com.example.WebUsersAccount.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Data
@Entity
@Component
@Table(name = "list_of_operations")
public class Operations {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_operation")
        private int idOperation;

        @ManyToOne
        @JoinColumn(name = "users_account_id")
        private Users users;

        @Column(name = "type_operation")
        private String Type_operation;

        @Column(name = "timeOfOperation")
        private LocalDateTime timeOfOperation;

        @Column(name = "sum_operation")
        private int sumOfOperation;
}
