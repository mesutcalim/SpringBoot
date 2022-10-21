package com.mesutcalim.business.services.impl;

import com.mesutcalim.business.dto.EmployeeDto;
import com.mesutcalim.business.services.EmployeeServices;
import com.mesutcalim.data.entity.EmployeeEntity;
import com.mesutcalim.data.repository.EmployeeRepository;
import com.mesutcalim.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeServiceImpl implements EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    //List
    //http://localhost:8080/api/v1/employees
    @GetMapping("/employees")
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> listDto = new ArrayList<>();
        Iterable<EmployeeEntity> entities= employeeRepository.findAll();
        for(EmployeeEntity entity :entities){
            EmployeeDto employeeDto = entityToDto(entity);
            listDto.add(employeeDto);
        }

        return listDto;
    }

    //Save
    //http://localhost:8080/api/v1/employees
    @PostMapping("/employees")
    @Override
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = dtoToEntity(employeeDto);
        employeeRepository.save(employeeEntity);
        return employeeDto;
    }

    //Find
    //http://localhost:8080/api/v1/employees/1
    @GetMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable  Long id) throws Throwable {
        EmployeeEntity employee=  employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: "+ id));
        EmployeeDto employeeDto = entityToDto(employee);
        return ResponseEntity.ok(employeeDto);

    }

    //Update
    //http://localhost:8080/api/v1/employees
    @PutMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto employeeDetails) throws Throwable {
        EmployeeEntity employeeEntity = dtoToEntity(employeeDetails);//Model Mapper
        EmployeeEntity employee=  employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: "+ id));

        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setEmailId(employeeEntity.getEmailId());

        EmployeeEntity updatedEmployee=  employeeRepository.save(employee);
        EmployeeDto employeeDto = entityToDto(updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    //Delete
    //http://localhost:8080/api/v1/employees
    @DeleteMapping("/employees/{id}")
    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) throws Throwable {
        EmployeeEntity employeeEntity=  employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: "+id));
        employeeRepository.delete(employeeEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    ////////////////////////////////////////////////////////////////////
    //Model Mapper
    //Entity ==> Dto
    @Override
    public EmployeeDto entityToDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto =modelMapper.map(employeeEntity,EmployeeDto.class);
        return employeeDto;
    }

    //DTO ==>Entity
    @Override
    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto,EmployeeEntity.class);
        return employeeEntity;
    }
}
