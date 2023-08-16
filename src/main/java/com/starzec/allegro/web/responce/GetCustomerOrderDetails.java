package com.starzec.allegro.web.responce;

import com.starzec.allegro.model.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerOrderDetails {
    private Long id;
    private LocalDate date;
    protected Status status;
    private BigDecimal totalPrice;
    private Long productId;
    private Long orderId;




}
