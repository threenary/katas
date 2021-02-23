package com.codurance.repository;

import com.codurance.entity.ShoppingBasket;
import com.codurance.entity.UserID;

import java.util.HashMap;
import java.util.Map;

public class ShoppingBasketRepository {

    private Map<UserID, ShoppingBasket> shoppingBaskets = new HashMap<>();

    public void storeBasket(UserID userID, ShoppingBasket shoppingBasket) {
        shoppingBaskets.put(userID, shoppingBasket);
    }

    public ShoppingBasket basketFor(UserID userID) {
        return shoppingBaskets.get(userID);
    }
}
