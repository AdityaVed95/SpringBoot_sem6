package com.microservices.Order;

import java.util.ArrayList;
import com.microservices.Order.ProductOfOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestParam;

// api test:
// http://localhost:8001/api-exp3-part3-order/addProductToOrder/1
// http://localhost:8001/api-exp3-part3-order/showOrder
// http://localhost:8001/api-exp3-part3-order/getRemainingItemsOfAProduct/2

@RestController
@RequestMapping("/api-exp3-part3-order")
public class OrderRestController {
    @Autowired
    private RestTemplate restTemplate;

    ArrayList<ProductOfOrder> orderList = new ArrayList<>();

    @GetMapping("/getRemainingItemsOfAProduct/{id}")
    public String getRemainingItemsOfAProduct(@PathVariable int id) {
        String Response = restTemplate.getForObject(
                "http://localhost:8080/api-exp3-part3-productinventory/getRemainingItemsOfProduct/"
                        + String.valueOf(id),
                String.class);

        if (Response.equalsIgnoreCase("-1")) {
            return "Product with given Id does not exist";
        } else {
            return Response;
        }

    }

    @GetMapping("/addProductToOrder/{id}")
    public String addProductToOrder(@PathVariable int id) {

        String Response = restTemplate.getForObject(
                "http://localhost:8080/api-exp3-part3-productinventory/buyProduct/" + String.valueOf(id),
                String.class);

        if (Response.equalsIgnoreCase("0")) {
            return "Product with this id does not exist";
        }

        else if (Response.equalsIgnoreCase("1")) {
            return "Sorry !!! The inventory has zero items of this product, please come later";
        }

        else if (Response.equalsIgnoreCase("2")) {

            // if product is already in the order List:
            int flag = 0;
            for (ProductOfOrder pi : orderList) {
                if (pi.getId() == id) {
                    pi.setQuantity(pi.getQuantity() + 1);
                    flag = 1;
                }
            }

            // if product is not in the order list:
            if (flag == 0) {
                orderList.add(new ProductOfOrder(id, 1));
            }

            return "Product has been successfully added to your order List";
        }

        return "This must never execute";
    }

    @GetMapping("/showOrder")
    public ArrayList<ProductOfOrder> showOrder() {
        return orderList;
    }

}
