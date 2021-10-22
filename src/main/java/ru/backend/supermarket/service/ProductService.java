package ru.backend.supermarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.backend.supermarket.dto.ProductDto;
import ru.backend.supermarket.model.Product;
import ru.backend.supermarket.repository.ProductRepository;
import ru.backend.supermarket.specification.ProductSpecification;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public Page<Product> findAll(Map<String, String> params, Integer pageNumber, Integer pageSize) {
        final Specification<Product> specification = ProductSpecification.build(params);
        return productRepository.findAll(specification, PageRequest.of(pageNumber-1, pageSize));
    }

    public Product findById(UUID id) {
        return productRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
                String.format("product with id - %s was not found", id)));
    }
    public Optional<Product> findProductById(UUID id) {
        return productRepository.findById(id);
    }

    public Optional<ProductDto> findProductDtoById(UUID id) {
        return productRepository.findById(id).map(ProductDto::new);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(UUID id) {
        productRepository.deleteById(id);
    }
}
