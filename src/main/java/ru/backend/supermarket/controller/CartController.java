package ru.backend.supermarket.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.backend.supermarket.component.Cart;
import ru.backend.supermarket.dto.CartDto;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "/api/v1/cart")
@Api(value = "Cart", description = "Контроллер корзины")
public class CartController {
    private final Cart cart;

    @ApiOperation("Получение корзины")
    @GetMapping
    public CartDto getCart() {
        return new CartDto(cart);
    }

    @ApiOperation("Добавление в корзину")
    @PutMapping("/add/{id}")
    public void addToCart(@PathVariable UUID id) {
        cart.addToCart(id);
    }

    @ApiOperation("Очистка корзины")
    @DeleteMapping("/clear")
    public void clearCart() {
        cart.clear();
    }
}
