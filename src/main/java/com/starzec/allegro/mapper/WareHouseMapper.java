package com.starzec.allegro.mapper;

import com.starzec.allegro.entity.WareHouse;
import com.starzec.allegro.model.WareHouseDto;
import org.springframework.stereotype.Component;

@Component
public class WareHouseMapper {
    public WareHouse toEntity(WareHouseDto dto) {
        WareHouse wareHouse = new WareHouse();
        wareHouse.setName(dto.getName());
        wareHouse.setAddress(dto.getAddress());

        return wareHouse;
    }

    public WareHouseDto toDto(WareHouse entity) {
        WareHouseDto wareHouseDto = new WareHouseDto();
        wareHouseDto.setId(entity.getId());
        wareHouseDto.setName(entity.getName());
        wareHouseDto.setAddress(entity.getAddress());

        return wareHouseDto;
    }
}
