package com.example.WebUsersAccount.entities;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Entity
@Component
@Table(name = "list_of_operations")
public class Operations {


        @Getter
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_operation")
        private int idOperation;

        @ManyToOne
        @JoinColumn(name = "users_account_id")
        private Users users;

        @Getter
        @Column(name = "type_operation")
        private String Type_operation;

        @Getter
        @Column(name = "timeOfOperation")
        private LocalDateTime timeOfOperation;

        @Getter
        @Column(name = "sum_operation")
        private int sumOfOperation;

        public void setUsers(Users users) {
                this.users = users;
        }

        public void setType_operation(String type_operation) {
                Type_operation = type_operation;
        }

        public void setTimeOfOperation(LocalDateTime timeOfOperation) {
                this.timeOfOperation = timeOfOperation;
        }

        public void setSumOfOperation(int sumOfOperation) {
                this.sumOfOperation = sumOfOperation;
        }
}
