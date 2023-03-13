package com.my.interview.project.core.service;

import com.my.interview.project.core.mappers.ContactMapper;
import com.my.interview.project.core.mappers.CustomerMapper;
import com.my.interview.project.database.mysql.entities.Customer;
import com.my.interview.project.database.mysql.repositories.CustomerRepository;
import com.my.interview.project.web.resources.request.CustomerRequestDto;
import com.my.interview.project.web.resources.response.CustomerResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public CustomerResponseDto createNewCustomer(CustomerRequestDto customer) {

        return CustomerMapper.MAPPER.daoToResponseDto(
                customerRepository.save(
                        CustomerMapper.MAPPER.requestDtoToDao(customer)));
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers(){

        return customerRepository.findAll()
                .stream()
                .map(CustomerMapper.MAPPER::daoToResponseDto)
                .collect(Collectors.toList());

    }

    @Override
    public CustomerResponseDto getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        return customer.map(CustomerMapper.MAPPER::daoToResponseDto).orElse(null);

    }

    @Override
    public CustomerResponseDto updateCustomer(CustomerRequestDto customer) {

        Customer customerDatabase = customerRepository.getReferenceById(customer.getId());

        if(customer.getFistName() != null) customerDatabase.setFistName(customer.getFistName());
        if(customer.getLastName() != null) customerDatabase.setLastName(customer.getLastName());
        if(customer.getContactList() != null) customerDatabase.setContactList(customer.getContactList()
                .stream().map(ContactMapper.MAPPER::dtoToDao)
                .collect(Collectors.toList()));

        return CustomerMapper.MAPPER.daoToResponseDto(customerRepository.save(customerDatabase));

    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

}
