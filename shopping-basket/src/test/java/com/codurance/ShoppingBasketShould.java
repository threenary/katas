package com.codurance;

import com.codurance.entity.BasketItem;
import com.codurance.entity.ShoppingBasket;
import com.codurance.entity.UserID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ShoppingBasketShould {

    private BasketItem basket1Item;
    private ShoppingBasket shoppingBasket;

    @BeforeEach
    void setUp() {
        UserID userID = mock(UserID.class);
        basket1Item = mock(BasketItem.class);
        when(basket1Item.getDate()).thenReturn(LocalDate.now());
        shoppingBasket = new ShoppingBasket(userID, basket1Item.getDate());
    }

    @Test
    void have_only_one_item_when_basket_item_is_added() {
        // When
        shoppingBasket.addBasketItem(basket1Item);

        // Then
        assertEquals(1, shoppingBasket.getItems().size());
    }

    @Test
    void have_the_same_basket_items_as_the_ones_added() {
        // Given
        BasketItem basket2Item = mock(BasketItem.class);
        BasketItem basket3Item = mock(BasketItem.class);
        BasketItem basket4Item = mock(BasketItem.class);
        BasketItem basket5Item = mock(BasketItem.class);

        List<BasketItem> basketItems = Arrays.asList(
                basket1Item, basket2Item, basket3Item, basket4Item, basket5Item
        );

        // When
        shoppingBasket.addBasketItem(basket1Item);
        shoppingBasket.addBasketItem(basket2Item);
        shoppingBasket.addBasketItem(basket3Item);
        shoppingBasket.addBasketItem(basket4Item);
        shoppingBasket.addBasketItem(basket5Item);

        // Then
        assertEquals(basketItems, shoppingBasket.getItems());
    }

    @Test
    void calculate_the_total_price_for_all_basket_items() {
        // Given
        BasketItem basket2Item = mock(BasketItem.class);
        when(basket1Item.getTotalPrice()).thenReturn(10);
        when(basket2Item.getTotalPrice()).thenReturn(35);

        // When
        shoppingBasket.addBasketItem(basket1Item);
        shoppingBasket.addBasketItem(basket2Item);

        // Then
        assertEquals(45, shoppingBasket.getTotalPrice());
    }
}
