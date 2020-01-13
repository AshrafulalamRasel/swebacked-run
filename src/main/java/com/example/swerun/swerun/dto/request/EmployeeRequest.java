package com.example.swerun.swerun.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeRequest {
    private String name;
    private String email;
    private String position;
    private String gender;
}
