package ru.backend.supermarket.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.backend.supermarket.model.Product;
import ru.backend.supermarket.service.ProductService;

import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/catalog")
@Api(value = "Catalog", description = "Контроллер каталога продуктов")
public class ProductController {

    private final ProductService productService;

    @ApiOperation("Получение всех продуктов")
    @GetMapping("/products")
    public Page<Product> findAll(@RequestParam(required = false) Map<String, String> params,
                                 @RequestParam(name = "pag-number", defaultValue = "1") Integer pageNumber,
                                 @RequestParam(name = "page-size", defaultValue = "2") Integer pageSize) {
        return productService.findAll(params, pageNumber, pageSize);
    }

    @ApiOperation("Получение продукта")
    @GetMapping("/{id}")
    public Product findById(@PathVariable UUID id) {
        return productService.findById(id);
    }

    @ApiOperation("Создание нового продукта")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void create(@RequestBody Product product) {
        productService.save(product);
    }

    @ApiOperation("Обновление данных продукта")
    @PutMapping
    public Product update(@RequestBody Product product) {
        return productService.save(product);
    }

    @ApiOperation("Удание продукта")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        productService.deleteById(id);
    }
}
