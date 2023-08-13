package com.starzec.allegro.mapper;

import com.starzec.allegro.entity.Customer;
import com.starzec.allegro.model.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toEntity(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setCity(dto.getCity());
        customer.setStreet(dto.getStreet());
        customer.setPostalCode(dto.getPostalCode());

        return customer;
    }

    public CustomerDto toDto(Customer entity) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(entity.getId());
        customerDto.setFirstName(entity.getFirstName());
        customerDto.setLastName(entity.getLastName());
        customerDto.setEmail(entity.getEmail());
        customerDto.setPhone(entity.getPhone());
        customerDto.setCity(entity.getCity());
        customerDto.setStreet(entity.getStreet());
        customerDto.setPostalCode(entity.getPostalCode());

        return customerDto;
    }
}
