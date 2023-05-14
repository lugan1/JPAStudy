package com.example.studyjpa.entity;

import com.example.studyjpa.enumeration.DeliveryStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "delivery")
public class Delivery extends BaseColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DELIVERY_ID", nullable = false)
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    private String city;
    private String street;
    private String zipcode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
