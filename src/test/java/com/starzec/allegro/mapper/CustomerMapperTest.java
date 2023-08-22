package com.starzec.allegro.mapper;

import com.starzec.allegro.entity.Customer;
import com.starzec.allegro.model.CustomerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {

    CustomerMapper customerMapper ;

    @BeforeEach
    void setUp(){
        customerMapper = new CustomerMapper();
    }
    @Test
    void toEntity(){
        // given
        CustomerDto customerDto = new CustomerDto();
        // when
        customerDto.setFirstName("Tomasz");
        customerDto.setLastName("Stanach");
        customerDto.setEmail("ts@o2.pl");
        customerDto.setPhone("123123123");
        customerDto.setCity("Kraków");
        customerDto.setStreet("Jagielońska");
        customerDto.setPostalCode("33-330");
        Customer customer = customerMapper.toEntity(customerDto);
        // then
        Customer expect = new Customer();
        expect.setFirstName("Tomasz");
        expect.setLastName("Stanach");
        expect.setEmail("ts@o2.pl");
        expect.setPhone("123123123");
        expect.setCity("Kraków");
        expect.setStreet("Jagielońska");
        expect.setPostalCode("33-330");

        assertEquals(expect, customer);
    }

    @Test
    void toDto(){
        // given
        Customer customer = new Customer();
        // when
        customer.setId(1L);
        customer.setFirstName("Tomasz");
        customer.setLastName("Stanach");
        customer.setEmail("ts@o2.pl");
        customer.setPhone("123123123");
        customer.setCity("Kraków");
        customer.setStreet("Jagielońska");
        customer.setPostalCode("33-330");
        CustomerDto customerDto = customerMapper.toDto(customer);
        // then
        CustomerDto expect = new CustomerDto();
        expect.setId(1L);
        expect.setFirstName("Tomasz");
        expect.setLastName("Stanach");
        expect.setEmail("ts@o2.pl");
        expect.setPhone("123123123");
        expect.setCity("Kraków");
        expect.setStreet("Jagielońska");
        expect.setPostalCode("33-330");

        assertEquals(expect, customerDto);

    }


}