package com.codurance.entity;

import java.util.Objects;

public class ProductID {

    private int productID;

    public ProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductID productID1 = (ProductID) o;
        return productID == productID1.productID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID);
    }

    @Override
    public String toString() {
        return "ProductID{" +
                "productID=" + productID +
                '}';
    }
}
