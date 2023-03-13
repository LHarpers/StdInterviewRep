package com.my.interview.project.core.mappers;


import com.my.interview.project.database.mysql.entities.Customer;
import com.my.interview.project.web.resources.request.CustomerRequestDto;
import com.my.interview.project.web.resources.response.CustomerResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper MAPPER = Mappers.getMapper( CustomerMapper.class );

    CustomerResponseDto daoToResponseDto(Customer dao);

    Customer requestDtoToDao(CustomerRequestDto requestDto);
}
