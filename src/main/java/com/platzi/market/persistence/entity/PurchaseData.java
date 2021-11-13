package com.platzi.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "purchases")
@Getter
@Setter
public class PurchaseData {

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

    @ManyToOne
    @JoinColumn(name = "id_client", insertable = false, updatable = false)
    private ClientData client;

    @OneToMany(mappedBy = "purchase")
    private List<PurchasesProducts> products;
}
