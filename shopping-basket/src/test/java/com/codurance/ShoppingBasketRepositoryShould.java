package com.codurance;

import com.codurance.entity.ShoppingBasket;
import com.codurance.entity.UserID;
import com.codurance.repository.ShoppingBasketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

class ShoppingBasketRepositoryShould {

    private ShoppingBasketRepository shoppingBasketRepository;
    private UserID userID;

    @BeforeEach
    void setUp() {
        shoppingBasketRepository = new ShoppingBasketRepository();
        userID = mock(UserID.class);
    }

    @Test
    void return_null_for_user_id_that_does_not_have_a_basket() {
        assertNull(shoppingBasketRepository.basketFor(userID));
    }

    @Test
    void store_basket_for_user_id() {
        // When
        ShoppingBasket shoppingBasket = new ShoppingBasket(userID, LocalDate.now());
        shoppingBasketRepository.storeBasket(userID, shoppingBasket);

        // Then
        assertEquals(shoppingBasket, shoppingBasketRepository.basketFor(userID));
    }
}
