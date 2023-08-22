package com.starzec.allegro.provider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDtoProvider {
    private String name;
    private String description;
    private String region;
    private String imageUrl;
    private String brand;
    private String category;
    private Long ean;
}
