package ru.backend.supermarket.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import ru.backend.supermarket.model.Product;

import java.util.Map;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductSpecification {

    public static Specification<Product> titleEq(String title) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("title"), title);
    }

    public static Specification<Product> costEq(Integer cost) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("cost"), cost);
    }

    public static Specification<Product> build(Map<String, String> params) {
        return params.entrySet().stream()
                .filter(it-> StringUtils.hasText(it.getValue()))
                .map(it -> {
                    if ("name".equals(it.getKey())) {
                        return ProductSpecification.titleEq(it.getValue());
                    }
                    if ("age".equals(it.getKey())) {
                        return ProductSpecification.costEq(Integer.parseInt(it.getValue()));
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .reduce(Specification::and)
                .orElse(null);
    }
}
