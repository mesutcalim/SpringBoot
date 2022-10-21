package com.mesutcalim.data.repository;

import com.mesutcalim.data.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// JpaRepository > CrudRepository
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

}
