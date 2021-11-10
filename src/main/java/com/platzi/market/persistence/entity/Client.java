package com.platzi.market.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    private String id;

    private String name;

    private String surname;

    private String cellphone;

    private String address;

    private String email;

    public String getId() {
        return id;
    }

    public Client setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Client setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Client setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getCellphone() {
        return cellphone;
    }

    public Client setCellphone(String cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Client setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Client setEmail(String email) {
        this.email = email;
        return this;
    }
}
