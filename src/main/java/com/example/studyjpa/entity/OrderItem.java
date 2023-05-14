package com.example.studyjpa.entity;

import jakarta.persistence.*;

@Entity
public class OrderItem extends BaseColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEM_ID")
    private long id;

    private long orderId;
    private long itemId;

    private int orderPrice;

    private int count;

    public OrderItem() {
    }

    public OrderItem(long orderId, long itemId, int orderPrice, int count) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.orderPrice = orderPrice;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public long getOrderId() {
        return orderId;
    }

    public long getItemId() {
        return itemId;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public int getCount() {
        return count;
    }
}
