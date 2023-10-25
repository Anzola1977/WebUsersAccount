package com.example.WebUsersAccount.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users_account")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "balance")
    private int balance;

}