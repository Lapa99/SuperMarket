package ru.backend.supermarket.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CategoryDto {
    private UUID id;
    private String title;
}
