package com.platzi.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
public class ClientData {

    @Id
    private String id;

    private String name;

    private String surname;

    private String cellphone;

    private String address;

    private String email;

    @OneToMany(mappedBy = "client")
    private List<PurchaseData> purchases;
}
