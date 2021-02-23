package com.codurance;

import com.codurance.entity.Product;
import com.codurance.entity.ProductID;
import com.codurance.repository.ProductRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductRepositoryShould {

    @Test
    void return_lord_of_the_rings_for_product_id() {
        ProductRepository productRepository = new ProductRepository();
        ProductID productID = new ProductID(10001);
        Product lordOfTheRings = new Product(productID, "Lord of the Rings", 10);

        assertEquals(lordOfTheRings, productRepository.getProduct(productID));
    }
}
