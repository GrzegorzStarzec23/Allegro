package com.starzec.allegro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderDto {
    private Long id;
    private LocalDate date;
    private Status status;
    private BigDecimal totalPrice;
    private Long productId;
    private Long customerId;

    public CustomerOrderDto(LocalDate date, Status status, BigDecimal totalPrice, Long productId, Long customerId) {
        this.date = date;
        this.status = status;
        this.totalPrice = totalPrice;
        this.productId = productId;
        this.customerId = customerId;
    }

    public CustomerOrderDto(LocalDate date, Status status, Long productId, Long customerId) {
        this.date = date;
        this.status = status;
        this.productId = productId;
        this.customerId = customerId;
    }
}
