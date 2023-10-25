package com.example.WebUsersAccount.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "list_of_operations")
public class ListOfOperations {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id_operation")
        private int idOfOperation;

        @OneToOne(cascade = {CascadeType.ALL})
        @JoinColumn(name = "users_account_id", referencedColumnName = "id")
        private Users users;

        @Column(name = "type_operation")
        private int typeOfOperation;

        @Column(name = "sum_operation")
        private int sumOfOperation;
}
