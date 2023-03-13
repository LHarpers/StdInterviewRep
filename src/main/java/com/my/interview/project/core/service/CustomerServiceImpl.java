package com.my.interview.project.core.service;

import com.my.interview.project.core.mappers.ContactMapper;
import com.my.interview.project.core.mappers.CustomerMapper;
import com.my.interview.project.database.mysql.entities.Contact;
import com.my.interview.project.database.mysql.entities.Customer;
import com.my.interview.project.database.mysql.repositories.CustomerRepository;
import com.my.interview.project.web.resources.ContactDto;
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
        Customer customerDatabase = CustomerMapper.MAPPER.requestDtoToDao(customer);
        customerDatabase.getContactList().forEach(contact -> {
            contact.setCustomer(customerDatabase);
        });

        return CustomerMapper.MAPPER.daoToResponseDto(
                customerRepository.save(customerDatabase));
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

        if(customer.getFirstName() != null) customerDatabase.setFirstName(customer.getFirstName());
        if(customer.getLastName() != null) customerDatabase.setLastName(customer.getLastName());
        if(customer.getContactList() != null) customerDatabase.setContactList(customer.getContactList()
                .stream().map((ContactMapper.MAPPER::dtoToDao))
                .peek(contact -> contact.setCustomer(customerDatabase))
                .collect(Collectors.toList()));

        return CustomerMapper.MAPPER.daoToResponseDto(customerRepository.save(customerDatabase));

    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

}
