package com.my.interview.project.core.mappers;

import com.my.interview.project.database.mysql.entities.Contact;
import com.my.interview.project.database.mysql.entities.Customer;
import com.my.interview.project.web.resources.ContactDto;
import com.my.interview.project.web.resources.request.CustomerRequestDto;
import com.my.interview.project.web.resources.response.CustomerResponseDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-13T02:40:54-0300",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 11.0.15 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerResponseDto daoToResponseDto(Customer dao) {
        if ( dao == null ) {
            return null;
        }

        CustomerResponseDto customerResponseDto = new CustomerResponseDto();

        customerResponseDto.setId( dao.getId() );
        customerResponseDto.setFirstName( dao.getFirstName() );
        customerResponseDto.setLastName( dao.getLastName() );
        customerResponseDto.setContactList( contactListToContactDtoList( dao.getContactList() ) );

        return customerResponseDto;
    }

    @Override
    public Customer requestDtoToDao(CustomerRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( requestDto.getId() );
        customer.setFirstName( requestDto.getFirstName() );
        customer.setLastName( requestDto.getLastName() );
        customer.setContactList( contactDtoListToContactList( requestDto.getContactList() ) );

        return customer;
    }

    protected ContactDto contactToContactDto(Contact contact) {
        if ( contact == null ) {
            return null;
        }

        ContactDto contactDto = new ContactDto();

        contactDto.setId( contact.getId() );
        contactDto.setContact( contact.getContact() );

        return contactDto;
    }

    protected List<ContactDto> contactListToContactDtoList(List<Contact> list) {
        if ( list == null ) {
            return null;
        }

        List<ContactDto> list1 = new ArrayList<ContactDto>( list.size() );
        for ( Contact contact : list ) {
            list1.add( contactToContactDto( contact ) );
        }

        return list1;
    }

    protected Contact contactDtoToContact(ContactDto contactDto) {
        if ( contactDto == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setId( contactDto.getId() );
        contact.setContact( contactDto.getContact() );

        return contact;
    }

    protected List<Contact> contactDtoListToContactList(List<ContactDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Contact> list1 = new ArrayList<Contact>( list.size() );
        for ( ContactDto contactDto : list ) {
            list1.add( contactDtoToContact( contactDto ) );
        }

        return list1;
    }
}
