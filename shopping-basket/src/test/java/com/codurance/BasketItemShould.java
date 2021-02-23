package com.codurance;

import com.codurance.entity.BasketItem;
import com.codurance.entity.DateProvider;
import com.codurance.entity.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BasketItemShould {

    @Test
    void calculate_total_price_for_a_basket_item() {
        final int quantity = 2;

        Product product = mock(Product.class);
        DateProvider dateProvider = mock(DateProvider.class);
        BasketItem basketItem = new BasketItem(product, quantity, dateProvider);

        when(product.getPrice()).thenReturn(5);

        assertEquals(10, basketItem.getTotalPrice());
    }
}
