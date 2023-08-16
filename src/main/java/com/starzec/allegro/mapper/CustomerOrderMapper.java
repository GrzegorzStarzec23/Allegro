package com.starzec.allegro.mapper;

import com.starzec.allegro.entity.CustomerOrder;
import com.starzec.allegro.model.CustomerOrderDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerOrderMapper {
    public CustomerOrder toEntity(CustomerOrderDto dto) {
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setDate(dto.getDate());
        customerOrder.setStatus(dto.getStatus());
        customerOrder.setTotalPrice(dto.getTotalPrice());


        return customerOrder;
    }

    public CustomerOrderDto toDto(CustomerOrder entity) {
        CustomerOrderDto customerOrderDto = new CustomerOrderDto();
        customerOrderDto.setId(entity.getId());
        customerOrderDto.setDate(entity.getDate());
        customerOrderDto.setStatus(entity.getStatus());
        customerOrderDto.setTotalPrice(entity.getTotalPrice());

        return customerOrderDto;
    }
}
