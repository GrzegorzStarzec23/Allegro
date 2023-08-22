package com.starzec.allegro.mapper;

import com.starzec.allegro.entity.WareHouse;
import com.starzec.allegro.model.WareHouseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WareHouseMapperTest {
    private WareHouseMapper wereHouseMapper;

    @BeforeEach
    void setUp() {
        wereHouseMapper = new WareHouseMapper();
    }

    @Test
    void toEntity() {
        //given
        WareHouseDto wareHouseDto = new WareHouseDto();
        //when
        wareHouseDto.setName("1234");
        wareHouseDto.setAddress("32-450");
        WareHouse wareHouse = wereHouseMapper.toEntity(wareHouseDto);
        //then
        WareHouse expected = new WareHouse();
        expected.setName("1234");
        expected.setAddress("32-450");

        assertEquals(expected, wareHouse);
    }

    @Test
    void toDto() {
        //given
        WareHouse wereHouse = new WareHouse();
        //when
        wereHouse.setId(1L);
        wereHouse.setName("123");
        wereHouse.setAddress("31-300");
        WareHouseDto wereHouseDto = wereHouseMapper.toDto(wereHouse);
        //then
        WareHouseDto expected = new WareHouseDto();
        expected.setId(1L);
        expected.setName("123");
        expected.setAddress("31-300");

        assertEquals(wereHouseDto, expected);
    }

}