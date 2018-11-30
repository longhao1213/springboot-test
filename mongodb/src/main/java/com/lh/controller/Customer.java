package com.lh.controller;

import org.springframework.data.annotation.Id;

public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;
    public String firstName1;
    public String lastName1;
    public String firstName2;
    public String lastName2;
    public String firstName3;
    public String lastName3;
    public String firstName4;
    public String lastName4;
    public String firstName5;
    public String lastName5;
    public String firstName6;
    public String lastName6;
    public String firstName7;
    public String lastName7;
    public String firstName8;
    public String lastName8;

    public Customer() {}

    public Customer(String firstName, String lastName, String firstName1, String lastName1, String firstName2, String lastName2, String firstName3, String lastName3, String firstName4, String lastName4, String firstName5, String lastName5, String firstName6, String lastName6, String firstName7, String lastName7, String firstName8, String lastName8) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.firstName1 = firstName1;
        this.lastName1 = lastName1;
        this.firstName2 = firstName2;
        this.lastName2 = lastName2;
        this.firstName3 = firstName3;
        this.lastName3 = lastName3;
        this.firstName4 = firstName4;
        this.lastName4 = lastName4;
        this.firstName5 = firstName5;
        this.lastName5 = lastName5;
        this.firstName6 = firstName6;
        this.lastName6 = lastName6;
        this.firstName7 = firstName7;
        this.lastName7 = lastName7;
        this.firstName8 = firstName8;
        this.lastName8 = lastName8;
    }
}