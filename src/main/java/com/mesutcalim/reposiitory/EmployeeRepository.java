package com.mesutcalim.reposiitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// JpaRepository > CrudRepository
@Repository
public interface EmployeeRepository extends CrudRepository {

}
