package ru.backend.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.backend.supermarket.model.Category;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
