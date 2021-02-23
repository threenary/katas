package com.codurance;

import com.codurance.entity.*;
import com.codurance.repository.ProductRepository;
import com.codurance.repository.ShoppingBasketRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingBasketServiceFeature {

    @Test
    void should_be_able_to_return_shopping_basket_with_the_first_item_added() {
        // Given
        UserID user1ID = new UserID(1);
        ProductID product1ID = new ProductID(10001);
        final int quantity = 2;

        Product lordOfTheRings = new Product(product1ID, "Lord of the Rings", 10);
        DateProvider currentDate = new CurrentDate();
        BasketItem basketItem = new BasketItem(lordOfTheRings, quantity, currentDate);
        ShoppingBasket shoppingBasket = new ShoppingBasket(user1ID, basketItem.getDate());
        shoppingBasket.addBasketItem(basketItem);

        ShoppingBasketRepository shoppingBasketRepository = new ShoppingBasketRepository();
        ProductRepository productRepository = new ProductRepository();
        ShoppingBasketService shoppingBasketService = new ShoppingBasketService(shoppingBasketRepository, productRepository, currentDate);

        // When
        shoppingBasketService.addItem(user1ID, product1ID, quantity);

        // Then
        assertEquals(shoppingBasketService.basketFor(user1ID), shoppingBasket);
    }

//    @Test
//    void should_log_all_items_in_the_basket_to_the_console() {
//        assertEquals("[BASKET CREATED]: Created[2019-07-12], User[1]\n" +
//                        "[ITEM ADDED TO SHOPPING CART]: Added[2019-07-12], User[1], Product[10001], Quantity[2], Price[10]\n" +
//                        "[ITEM ADDED TO SHOPPING CART]: Added[2019-07-12], User[1], Product[10002], Quantity[5], Price[5]\n",
//                shoppingBasketService.log());
//    }
}
