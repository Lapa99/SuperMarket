package ru.backend.supermarket.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.backend.supermarket.model.OrderItem;

@NoArgsConstructor
@Data
public class OrderItemDto {
    private String productTitle;
    private int quantity;
    private int pricePerProduct;
    private int price;

    public OrderItemDto(OrderItem orderItem) {
        this.productTitle = orderItem.getProduct().getTitle();
        this.quantity = orderItem.getQuantity();
        this.pricePerProduct = orderItem.getPricePerProduct();
        this.price = orderItem.getPrice();
    }
}
