package com.codurance.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShoppingBasket {

    private final UserID userID;
    private final LocalDate dateCreated;

    private List<BasketItem> basketItems = new ArrayList<>();

    public ShoppingBasket(UserID userID, LocalDate dateCreated) {
        this.userID = userID;
        this.dateCreated = dateCreated;
    }

    public void addBasketItem(BasketItem basketItem) {
        basketItems.add(basketItem);
    }

    public List<BasketItem> getItems() {
        return basketItems;
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for (BasketItem item : basketItems) {
            totalPrice += item.getTotalPrice();
        }

        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingBasket that = (ShoppingBasket) o;
        return Objects.equals(userID, that.userID) &&
                Objects.equals(dateCreated, that.dateCreated) &&
                Objects.equals(basketItems, that.basketItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, dateCreated, basketItems);
    }

    @Override
    public String toString() {
        return "ShoppingBasket{" +
                "userID=" + userID +
                ", dateCreated=" + dateCreated +
                ", basketItems=" + basketItems +
                '}';
    }
}
