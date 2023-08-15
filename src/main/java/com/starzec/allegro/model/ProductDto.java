package com.starzec.allegro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Long quantity;
    private Long wareHouseId;

    public ProductDto(String name, String description, BigDecimal price, Long quantity, Long wareHouseId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.wareHouseId = wareHouseId;
    }
}
