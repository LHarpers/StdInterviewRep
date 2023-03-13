package com.my.interview.project.web.resources.response;

import com.my.interview.project.database.mysql.entities.Contact;
import com.my.interview.project.web.resources.ContactDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {

    private String fistName;

    private String lastName;

    private List<ContactDto> contactList;

}
