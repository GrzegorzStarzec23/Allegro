package com.starzec.allegro.web.request;

import com.starzec.allegro.model.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAndUpdateCustomerOrderRequest {
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected Status status;
    @Column(nullable = false)
    private BigDecimal totalPrice;
    @NotNull
    private Long productId;
    @NotNull
    private Long customerId;


}
