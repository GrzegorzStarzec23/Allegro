package com.starzec.allegro.provider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String code;
    private String codeType;
    private ProductDto product;
    private String barcodeUrl;

}
