package ru.backend.supermarket.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "order_items")
@Entity
@NoArgsConstructor
@Data
public class OrderItem {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "quantity", nullable = true)
    private Integer quantity;
    @Column(name = "price_per_product", nullable = false)
    private int pricePerProduct;
    @Column(name = "price", nullable = false)
    private int price;

    public OrderItem(Product product) {
        this.product = product;
        this.quantity = 1;
        this.pricePerProduct = product.getCost();
        this.price = this.pricePerProduct;
    }

    public void incrementQuantity() {
        quantity++;
        price = pricePerProduct * quantity;
    }
    public void decrementQuantity() {
        quantity--;
        price = pricePerProduct * quantity;
    }
}
