package com.my.interview.project.database.mysql.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String fistName;

    @Column
    @NotNull
    private String lastName;

    @Column
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Contact> contactList = new ArrayList<>();

}
