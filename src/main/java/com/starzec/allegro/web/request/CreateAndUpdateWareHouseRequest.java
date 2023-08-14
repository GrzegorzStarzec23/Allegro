package com.starzec.allegro.web.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAndUpdateWareHouseRequest {
    @Column(nullable = false, length = 255)
    private String name;
    @Column(nullable = false, length = 255)
    private String address;

}
