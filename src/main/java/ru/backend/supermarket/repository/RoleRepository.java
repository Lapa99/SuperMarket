package ru.backend.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.backend.supermarket.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
