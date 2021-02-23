package com.codurance;

import com.codurance.entity.*;
import com.codurance.repository.ProductRepository;
import com.codurance.repository.ShoppingBasketRepository;

import java.time.LocalDate;

public class ShoppingBasketService {

    private final ShoppingBasketRepository shoppingBasketRepository;
    private final ProductRepository productRepository;
    private DateProvider dateProvider;

    public ShoppingBasketService(ShoppingBasketRepository shoppingBasketRepository, ProductRepository productRepository, DateProvider dateProvider) {
        this.shoppingBasketRepository = shoppingBasketRepository;
        this.productRepository = productRepository;
        this.dateProvider = dateProvider;
    }

    public void addItem(UserID userID, ProductID productID, int quantity) {
        Product product = productRepository.getProduct(productID);
        BasketItem basketItem = new BasketItem(product, quantity, dateProvider);
        ShoppingBasket shoppingBasket = getOrCreateShoppingBasket(userID, basketItem.getDate());

        shoppingBasket.addBasketItem(basketItem);
    }

    public ShoppingBasket basketFor(UserID userID) {
        return shoppingBasketRepository.basketFor(userID);
    }

    private ShoppingBasket getOrCreateShoppingBasket(UserID userID, LocalDate basketCreationDate) {
        ShoppingBasket shoppingBasket = shoppingBasketRepository.basketFor(userID);

        if (shoppingBasket == null) {
            shoppingBasket = new ShoppingBasket(userID, basketCreationDate);
            shoppingBasketRepository.storeBasket(userID, shoppingBasket);
        }

        return shoppingBasket;
    }
}
