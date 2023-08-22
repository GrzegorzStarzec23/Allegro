package com.starzec.allegro.mapper;

import com.starzec.allegro.entity.CustomerOrder;
import com.starzec.allegro.model.CustomerOrderDto;
import com.starzec.allegro.model.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerOrderMapperTest {
    private CustomerOrderMapper customerOrderMapper;

    @BeforeEach
    void setUp() {
        customerOrderMapper = new CustomerOrderMapper();
    }

    @Test
    void toEntity() {
        // given
        CustomerOrderDto dto = new CustomerOrderDto();
        // when
        dto.setDate(LocalDate.of(2020, 8, 20));
        dto.setStatus(Status.NEW);
        dto.setTotalPrice(BigDecimal.ONE);
        CustomerOrder customerOrder = customerOrderMapper.toEntity(dto);
        // then
        CustomerOrder expected = new CustomerOrder();
        expected.setDate(LocalDate.of(2020, 8, 20));
        expected.setStatus(Status.NEW);
        expected.setTotalPrice(BigDecimal.ONE);

        assertEquals(expected, customerOrder);
    }

    @Test
    void toDto() {
        // given
        CustomerOrder customerOrder = new CustomerOrder();
        // when
        customerOrder.setId(1L);
        customerOrder.setDate(LocalDate.of(2020, 8, 20));
        customerOrder.setStatus(Status.NEW);
        customerOrder.setTotalPrice(BigDecimal.ONE);
        CustomerOrderDto dto = customerOrderMapper.toDto(customerOrder);
        // then
        CustomerOrderDto expected = new CustomerOrderDto();
        expected.setId(1L);
        expected.setDate(LocalDate.of(2020, 8, 20));
        expected.setStatus(Status.NEW);
        expected.setTotalPrice(BigDecimal.ONE);

        assertEquals(expected, dto);
    }
}