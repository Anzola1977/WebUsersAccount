package com.example.WebUsersAccount.entities;

import com.example.WebUsersAccount.Type_operation;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "list_of_operations")
public class ListOfOperations {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id_operation")
        private int idOperation;

        @OneToOne(cascade = {CascadeType.ALL})
        @JoinColumn(name = "users_account_id", referencedColumnName = "id")
        private Users users;

        @Column(name = "type_operation")
        private Enum<Type_operation> Type_operation;

        @Column(name = "timeOfOperation")
        private Timestamp timeOfOperation;

        @Column(name = "sum_operation")
        private int sumOfOperation;
}
