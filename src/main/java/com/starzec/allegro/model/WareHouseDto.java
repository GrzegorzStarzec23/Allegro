package com.starzec.allegro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WareHouseDto {
    private Long id;
    private String name;
    private String address;

    public WareHouseDto(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
