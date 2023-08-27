package com.example.shoppingcart_quiz1;

public class OrderItem {
    private com.example.shoppingcart_quiz1.Product product;
    private int quantity;

    public OrderItem(com.example.shoppingcart_quiz1.Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public com.example.shoppingcart_quiz1.Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
