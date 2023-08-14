package com.starzec.allegro.web.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetWareHouseDetails {
    private Long id;
    private String name;
    private String address;

}
