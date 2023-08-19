package com.starzec.allegro.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductEanDto {
    private String code;
    private String codeType;
    private String name;
    private String description;
    private String region;
    private String imageUrl;
    private String brand;
    private Long ean;
    private String barcodeUrl;
}
