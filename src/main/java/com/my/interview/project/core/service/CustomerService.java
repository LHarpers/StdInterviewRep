package com.my.interview.project.core.service;

import com.my.interview.project.web.resources.request.CustomerRequestDto;
import com.my.interview.project.web.resources.response.CustomerResponseDto;

import java.util.List;

public interface CustomerService {

    CustomerResponseDto createNewCustomer(CustomerRequestDto employee);

    List<CustomerResponseDto> getAllCustomers();

    CustomerResponseDto getCustomerById(Long id);

    CustomerResponseDto updateCustomer(CustomerRequestDto customer);

    void deleteCustomer(Long id);
}
