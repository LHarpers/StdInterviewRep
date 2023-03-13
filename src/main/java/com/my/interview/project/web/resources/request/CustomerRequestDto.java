package com.my.interview.project.web.resources.request;

import com.my.interview.project.web.resources.ContactDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

    private Long Id;

    private String firstName;

    private String lastName;

    private List<ContactDto> contactList;

}
