package com.example.WebUsersAccount;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="bankaccount")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUser")
    private int id;

    @Column(name="nameUser")
    private String name;

    @Column(name="currentBalance")
    private int currentBalance;

}