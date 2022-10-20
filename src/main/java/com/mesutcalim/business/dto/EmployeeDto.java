package com.mesutcalim.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

//DTO: Data Transfer Object
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class EmployeeDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String emailId;
}
