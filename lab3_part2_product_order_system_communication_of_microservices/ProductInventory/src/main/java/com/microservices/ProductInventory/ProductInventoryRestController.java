package com.microservices.ProductInventory;

import java.util.ArrayList;
import java.util.List;

import com.microservices.ProductInventory.ProductInventory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// api test:

// http://localhost:8080/api-exp3-part3-productinventory/showAllProductsInventory
// http://localhost:8080/api-exp3-part3-productinventory/getRemainingItemsOfProduct/0
// http://localhost:8080/api-exp3-part3-productinventory/buyProduct/0

@RestController
@RequestMapping("/api-exp3-part3-productinventory")
// This is a controller class

public class ProductInventoryRestController {

    ArrayList<ProductInventory> currentProductInventory = new ArrayList<>();

    ProductInventoryRestController() {
        currentProductInventory.add(new ProductInventory(0, "Milk", 100, 5));
        currentProductInventory.add(new ProductInventory(1, "Bread", 150, 10));
        currentProductInventory.add(new ProductInventory(2, "Apple", 50, 30));
        currentProductInventory.add(new ProductInventory(3, "Banana", 30, 40));
    }

    @GetMapping("/showAllProductsInventory")
    public Object showAllProductsDetails() {
        return currentProductInventory;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    // basically remove one item of the product from inventory:
    @GetMapping("/buyProduct/{id}")
    public String buyProduct(@PathVariable int id) {
        int flag = 0;
        for (ProductInventory pi : currentProductInventory) {

            if (pi.getId() == id) {
                int status = pi.buyProduct();
                if (status == 0) {
                    flag = 1;
                } else {
                    flag = 2;
                }

            }
        }
        // product with pid does not exist
        if (flag == 0) {
            return String.valueOf(0);
        }

        // product with pid has 0 items left in inventory
        else if (flag == 1) {
            return String.valueOf(1);
        }

        // successfully update inventory by removing one product
        else if (flag == 2) {
            return String.valueOf(2);
        }

        return "This must never execute";
        // else {
        // return 0;
        // }

    }

    @GetMapping("/getRemainingItemsOfProduct/{id}")
    public String getRemainingItemsOfProduct(@PathVariable int id) {

        for (ProductInventory pi : currentProductInventory) {
            if (pi.getId() == id) {
                return String.valueOf(pi.getItemsLeft());
            }
        }

        return String.valueOf(-1);

    }

}
