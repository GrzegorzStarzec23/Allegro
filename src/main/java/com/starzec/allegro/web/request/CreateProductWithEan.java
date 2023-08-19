package com.starzec.allegro.web.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CreateProductWithEan {
    @NotBlank
    private String ean;
    @Min(10)
    private BigDecimal price;
    @Min(1)
    private Long quantity;
    @NotNull
    private Long wareHouseId;
}
