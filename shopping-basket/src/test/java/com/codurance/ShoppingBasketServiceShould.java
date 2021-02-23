package com.codurance;

import com.codurance.entity.*;
import com.codurance.repository.ProductRepository;
import com.codurance.repository.ShoppingBasketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

class ShoppingBasketServiceShould {

    private ShoppingBasketRepository shoppingBasketRepository;
    private ProductRepository productRepository;
    private DateProvider dateProvider;
    private ShoppingBasketService shoppingBasketService;
    private UserID userID;

    @BeforeEach
    void setUp() {
        shoppingBasketRepository = mock(ShoppingBasketRepository.class);
        productRepository = mock(ProductRepository.class);
        dateProvider = mock(DateProvider.class);
        shoppingBasketService = new ShoppingBasketService(shoppingBasketRepository, productRepository, dateProvider);
        userID = mock(UserID.class);
    }

    @Test
    void invoke_the_shopping_basket_repository_create_basket_method_once_when_two_items_added() {
        // Given
        ProductID productID = mock(ProductID.class);
        final int quantity = 2;
        final int price = 10;
        final String productName = "Lord of the Rings";

        when(productRepository.getProduct(productID)).thenReturn(new Product(productID, productName, price));
        when(dateProvider.getDate()).thenReturn(LocalDate.now());

        Product product = productRepository.getProduct(productID);
        BasketItem basketItem = new BasketItem(product, quantity, dateProvider);
        ShoppingBasket shoppingBasket = new ShoppingBasket(userID, basketItem.getDate());

        when(shoppingBasketRepository.basketFor(userID)).thenReturn(null).thenReturn(shoppingBasket);

        // When
        shoppingBasketService.addItem(userID, productID, quantity);
        shoppingBasketService.addItem(userID, productID, quantity);

        // Then
        verify(shoppingBasketRepository).storeBasket(userID, shoppingBasket);
    }

    @Test
    void invoke_the_shopping_basket_repository_basket_for_method_when_basket_for_is_called() {
        // When
        shoppingBasketService.basketFor(userID);

        // Then
        verify(shoppingBasketRepository).basketFor(userID);
    }
}
