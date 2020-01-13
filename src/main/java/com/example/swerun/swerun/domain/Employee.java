package com.example.swerun.swerun.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE_INFO")
public class Employee {

    @Id
    private String id;
    private String name;
    private String email;
    private String position;
    private String gender;
}
