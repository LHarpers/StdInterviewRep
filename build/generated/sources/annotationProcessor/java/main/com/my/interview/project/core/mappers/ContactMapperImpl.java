package com.my.interview.project.core.mappers;

import com.my.interview.project.database.mysql.entities.Contact;
import com.my.interview.project.web.resources.ContactDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-13T01:47:13-0300",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 11.0.15 (Oracle Corporation)"
)
public class ContactMapperImpl implements ContactMapper {

    @Override
    public ContactDto daoToDto(Contact dao) {
        if ( dao == null ) {
            return null;
        }

        ContactDto contactDto = new ContactDto();

        contactDto.setId( dao.getId() );
        contactDto.setContact( dao.getContact() );

        return contactDto;
    }

    @Override
    public Contact dtoToDao(ContactDto dto) {
        if ( dto == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setId( dto.getId() );
        contact.setContact( dto.getContact() );

        return contact;
    }
}
