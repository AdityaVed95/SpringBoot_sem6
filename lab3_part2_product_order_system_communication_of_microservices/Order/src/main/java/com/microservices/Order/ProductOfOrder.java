package com.microservices.Order;

public class ProductOfOrder {
    int id;
    int quantity;

    public ProductOfOrder(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
