package com.example.WebUsersAccount;

import lombok.Getter;

@Getter
public enum Type_operation {
    PUT("PUT MONEY"),
    TAKE("TAKE MONEY"),
    GET("GET BALANCE");

    private final String typeOfOperations;

    Type_operation(String typeOfOperations) {
        this.typeOfOperations = typeOfOperations;
    }

    @Override
    public String toString() {
        return String.format("Type of operation - %s", typeOfOperations);
    }
}
