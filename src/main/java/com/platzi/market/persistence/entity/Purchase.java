package com.platzi.market.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase")
    private Integer idPurchase;

    @Column(name = "id_client")
    private String idClient;

    private LocalDateTime date;

    @Column(name = "half_payment")
    private String halfPayment;

    private String comment;

    private String status;

    public Integer getIdPurchase() {
        return idPurchase;
    }

    public Purchase setIdPurchase(Integer idPurchase) {
        this.idPurchase = idPurchase;
        return this;
    }

    public String getIdClient() {
        return idClient;
    }

    public Purchase setIdClient(String idClient) {
        this.idClient = idClient;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Purchase setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public String getHalfPayment() {
        return halfPayment;
    }

    public Purchase setHalfPayment(String halfPayment) {
        this.halfPayment = halfPayment;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Purchase setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Purchase setStatus(String status) {
        this.status = status;
        return this;
    }
}
