package com.microservices.ProductInventory;

public class ProductInventory {

    int id;
    String name;
    float prize;
    int itemsLeft;

    public ProductInventory(int id, String name, float prize, int itemsLeft) {
        this.id = id;
        this.name = name;
        this.prize = prize;
        this.itemsLeft = itemsLeft;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrize() {
        return prize;
    }

    public int getItemsLeft() {
        return itemsLeft;
    }

    public int buyProduct() {
        if (this.itemsLeft == 0) {
            return 0;
        }
        this.itemsLeft -= 1;
        return 1;
    }

}
