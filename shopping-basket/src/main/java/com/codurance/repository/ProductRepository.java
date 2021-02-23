package com.codurance.repository;

import com.codurance.entity.Product;
import com.codurance.entity.ProductID;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    private Map<ProductID, Product> products = new HashMap<ProductID, Product>() {
        {
            ProductID product1ID = new ProductID(10001);
            Product product1 = new Product(product1ID, "Lord of the Rings", 10);

            ProductID product2ID = new ProductID(10002);
            Product product2 = new Product(product1ID, "The Hobbit", 5);

            ProductID product3ID = new ProductID(20001);
            Product product3 = new Product(product1ID, "Game of Thrones", 9);

            ProductID product4ID = new ProductID(20110);
            Product product4 = new Product(product1ID, "Breaking Bad", 7);

            put(product1ID, product1);
            put(product2ID, product2);
            put(product3ID, product3);
            put(product4ID, product4);
        }
    };

    public Product getProduct(ProductID productID) {
        return products.get(productID);
    }
}
