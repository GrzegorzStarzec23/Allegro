package com.starzec.allegro.service;

import com.starzec.allegro.entity.Customer;
import com.starzec.allegro.entity.CustomerOrder;
import com.starzec.allegro.entity.Product;
import com.starzec.allegro.mapper.CustomerOrderMapper;
import com.starzec.allegro.model.CustomerOrderDto;
import com.starzec.allegro.model.Status;
import com.starzec.allegro.repository.CustomerOrderRepository;
import com.starzec.allegro.repository.CustomerRepository;
import com.starzec.allegro.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@AllArgsConstructor
public class CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;
    private final CustomerOrderMapper customerOrderMapper;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public List<CustomerOrderDto> findAllCustomerOrders() {
        List<CustomerOrder> customerOrders = customerOrderRepository.findAll();
        return customerOrders.stream()
                .map(customerOrderMapper::toDto)
                .collect(Collectors.toList());
    }

    public void createNewCustomerOrder(CustomerOrderDto customerOrderDto) {
        Customer customer = customerRepository.findById(customerOrderDto.getCustomerId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Not found Customer with this id"));

        Product product = productRepository.findById(customerOrderDto.getProductId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Not found Product with id"));

        CustomerOrder customerOrder = customerOrderMapper.toEntity(customerOrderDto);

        customerOrder.setProducts(List.of(product));
        customerOrder.setCustomer(customer);
        customerOrder.setTotalPrice(product.getPrice());
        customerOrderRepository.save(customerOrder);
    }

    public void updateCustomerOrder(Long id, Status status, Long customerId, Long productId) {
        CustomerOrder customerOrder = customerOrderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Not found customer order with " + id + " id"));

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Not found customer with " + id + " id"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Not found product with " + id + " id"));

        customerOrder.setStatus(status);
        customerOrder.setCustomer(customer);
        customerOrder.setProducts(List.of(product));


        customerOrderRepository.save(customerOrder);
    }

    public boolean existById(Long id) {
        List<CustomerOrder> customerOrders = customerOrderRepository.findAll();
        return customerOrders.stream()
                .anyMatch(customerOrder -> customerOrder.getId().equals(id));
    }

    public void deleteCustomerOrder(Long id) {
        customerOrderRepository.deleteById(id);
    }
}
