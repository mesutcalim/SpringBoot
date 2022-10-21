package com.mesutcalim.business.services;

import com.mesutcalim.business.dto.EmployeeDto;
import com.mesutcalim.data.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeServices {

    //Crud
    public List<EmployeeDto> getAllEmployees();
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public ResponseEntity<EmployeeDto> getEmployeeById(Long id) throws Throwable;
    public ResponseEntity<EmployeeDto> updateEmployee(Long id, EmployeeDto employeeDto) throws Throwable;
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(Long id) throws Throwable;

    //Model Mapper
    public EmployeeDto entityToDto(EmployeeEntity employeeEntity);
    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto);
}
