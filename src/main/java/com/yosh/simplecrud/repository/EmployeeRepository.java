package com.yosh.simplecrud.repository;

import java.util.Optional;
import java.util.UUID;
import com.yosh.simplecrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployeeRepository
                extends JpaRepository<Employee, UUID>, JpaSpecificationExecutor<Employee> {
        Optional<Employee> findByNik(String nik);
}
