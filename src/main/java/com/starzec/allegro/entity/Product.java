package com.starzec.allegro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "wareHouse_id", nullable = false)
    private WareHouse wareHouse;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private List<CustomerOrder> customerOrders;
}
