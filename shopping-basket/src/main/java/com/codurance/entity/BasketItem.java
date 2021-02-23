package com.codurance.entity;

import java.time.LocalDate;
import java.util.Objects;

public class BasketItem {

    private final Product product;
    private final int quantity;
    private DateProvider dateProvider;

    public BasketItem(Product product, int quantity, DateProvider dateProvider) {
        this.product = product;
        this.quantity = quantity;
        this.dateProvider = dateProvider;
    }

    public LocalDate getDate() {
        return dateProvider.getDate();
    }

    public int getTotalPrice() {
        return product.getPrice() * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketItem that = (BasketItem) o;
        return quantity == that.quantity &&
                Objects.equals(product, that.product) &&
                Objects.equals(dateProvider, that.dateProvider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity, dateProvider);
    }

    @Override
    public String toString() {
        return "BasketItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", dateProvider=" + dateProvider +
                '}';
    }
}
