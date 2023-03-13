package com.my.interview.project.core.mappers;


import com.my.interview.project.database.mysql.entities.Contact;
import com.my.interview.project.web.resources.ContactDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactMapper {
    ContactMapper MAPPER = Mappers.getMapper( ContactMapper.class );

    ContactDto daoToDto(Contact dao);

    Contact dtoToDao(ContactDto dto);



}
