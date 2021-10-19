package ru.backend.supermarket.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.backend.supermarket.model.Product;

import java.util.UUID;

@NoArgsConstructor
@Data
public class ProductDto {
    private UUID id;
    private String title;
    private int cost;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.cost = product.getCost();
    }
}
