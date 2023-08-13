package com.starzec.allegro.service;

import com.starzec.allegro.entity.Customer;
import com.starzec.allegro.mapper.CustomerMapper;
import com.starzec.allegro.model.CustomerDto;
import com.starzec.allegro.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public List<CustomerDto> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<Customer> findIdCustomer(Long id) {
        return customerRepository.findById(id);
    }

    public void createNewCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toEntity(customerDto);
        customerRepository.save(customer);
    }

    public void updateCustomer(Long id, String firstName, String lastName, String email, String phone, String city, String street, String postCode) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, " Not found customer with this id"));
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setCity(city);
        customer.setStreet(street);
        customer.setPostalCode(postCode);
        customerRepository.save(customer);
    }

    public boolean existById(Long id) {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .anyMatch(customer -> customer.getId().equals(id));
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }


}
