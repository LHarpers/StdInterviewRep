package com.my.interview.project.web.rest.v1;

import com.my.interview.project.core.service.CustomerServiceImpl;
import com.my.interview.project.web.resources.request.CustomerRequestDto;
import com.my.interview.project.web.resources.response.CustomerResponseDto;
import com.my.interview.project.web.rest.RestControllerBase;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = RestControllerBase.BASE_URI + "/v1/customer")
public class CustomerController extends RestControllerBase {

    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerResponseDto> createNewCustomer(@RequestBody CustomerRequestDto customer){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.createNewCustomer(customer));
    }

    @GetMapping("/list")
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomers(){

        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomer(@NotNull @PathVariable Long id){

        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerResponseDto> updateCustomer(@RequestBody CustomerRequestDto customer){
        return ResponseEntity.ok(customerService.updateCustomer(customer));
    }

    @DeleteMapping("/delete/{id}")
    public void updateCustomer(@NotNull @PathVariable Long id){
        customerService.deleteCustomer(id);
        ResponseEntity.ok();
    }
}
