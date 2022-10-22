package com.mesutcalim;

import com.mesutcalim.data.entity.EmployeeEntity;
import com.mesutcalim.data.repository.EmployeeRepository;
import com.mesutcalim.test.TestCrud;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTests implements TestCrud {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void contextLoads() {
    }

    @Test
    @Override
    public void testCreate() {
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .firstName("Mesut Test").lastName("Çalım Test")
                .emailId("mesutcalim@gmail.com")
                .build();
        employeeRepository.save(employeeEntity);
        // nesne null ise assertion hatasını göndersin
        assertNotNull(employeeRepository.findById(1L).get());
    }

    @Test
    @Override
    public void testList() {
        List<EmployeeEntity> list = employeeRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    @Override
    public void testFindById() {
        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
        assertEquals("Mesut Test", employeeEntity.getFirstName());
    }

    @Test
    @Override
    public void testUpdate() {
        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
        employeeEntity.setFirstName("Mesut 51 Test");
        employeeRepository.save(employeeEntity);

        assertNotEquals("Mesut Test", employeeRepository.findById(1L).get().getFirstName());

    }

    @Test
    @Override
    public void testDelete() {
        employeeRepository.deleteById(1L);
        assertThat(employeeRepository.existsById(1L)).isFalse();
    }
}
