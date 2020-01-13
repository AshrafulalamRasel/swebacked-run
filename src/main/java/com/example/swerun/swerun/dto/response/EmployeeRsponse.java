package com.example.swerun.swerun.dto.response;

import lombok.*;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRsponse {
    private String name;
    private String email;
    private String position;
    private String gender;
}
