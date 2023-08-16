package com.starzec.allegro.web;

import com.starzec.allegro.model.CustomerOrderDto;
import com.starzec.allegro.service.CustomerOrderService;
import com.starzec.allegro.web.request.CreateAndUpdateCustomerOrderRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/product/customer/order")
@AllArgsConstructor
public class CustomerOrderController {

    private final CustomerOrderService customerOrderService;

    @GetMapping
    public List<CustomerOrderDto> findAllCustomerOrders() {
        return customerOrderService.findAllCustomerOrders();
    }

    @PostMapping
    public void createNewCustomerOrder(@RequestBody CreateAndUpdateCustomerOrderRequest request) {
        CustomerOrderDto customerOrderDto = new CustomerOrderDto(request.getDate(), request.getStatus(), request.getProductId(), request.getCustomerId());
        customerOrderService.createNewCustomerOrder(customerOrderDto);
    }

    @PutMapping("/{id}")
    public void updateCustomerOrder(@PathVariable Long id, @RequestBody CreateAndUpdateCustomerOrderRequest request){
        customerOrderService.updateCustomerOrder(id, request.getStatus(), request.getProductId(), request.getCustomerId());
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerOrder(@PathVariable Long id){
        if (customerOrderService.existById(id)){
            customerOrderService.deleteCustomerOrder(id);
        } else
            throw new ResponseStatusException(NOT_FOUND, "CustomerOrder with given id "+ id +"not found");
    }

}
