package com.starzec.allegro.web;

import com.starzec.allegro.entity.Customer;
import com.starzec.allegro.model.CustomerDto;
import com.starzec.allegro.service.CustomerService;
import com.starzec.allegro.web.request.CreateAndUpdateCustomerRequest;
import com.starzec.allegro.web.responce.GetCustomerDetails;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDto> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/{id}")
    public GetCustomerDetails customerDetails(@PathVariable Long id) {
        final Optional<Customer> customer = customerService.findIdCustomer(id);
        return customer.map(custom -> new GetCustomerDetails(custom.getId(), custom.getFirstName(), custom.getLastName(), custom.getEmail(), custom.getPhone(), custom.getCity(), custom.getStreet(), custom.getPostalCode()))
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Customer with id " + id + " doesnt exist"));
    }

    @PostMapping
    public void createNewCustomer(@RequestBody CreateAndUpdateCustomerRequest request) {
        CustomerDto customerDto = new CustomerDto(request.getFirstName(), request.getLastName(), request.getEmail(), request.getPhone(), request.getCity(), request.getStreet(), request.getPostalCode());
        customerService.createNewCustomer(customerDto);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable Long id, @RequestBody CreateAndUpdateCustomerRequest request) {
        customerService.updateCustomer(id, request.getFirstName(), request.getLastName(), request.getEmail(), request.getPhone(), request.getCity(), request.getStreet(), request.getPostalCode());
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        if (customerService.existById(id)) {
            customerService.deleteCustomer(id);
        } else
            throw new ResponseStatusException(NOT_FOUND, "Customer with given id " + id + "not found");
    }
}
