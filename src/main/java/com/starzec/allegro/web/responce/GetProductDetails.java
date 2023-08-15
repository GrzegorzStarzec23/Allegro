package com.starzec.allegro.web.responce;

import com.starzec.allegro.entity.WareHouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductDetails {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Long quantity;
    private Long wareHouseId;

    public GetProductDetails(Long id, String name, String description, BigDecimal price, Long quantity, WareHouse wareHouse) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.wareHouseId = wareHouse.getId();
    }


}
