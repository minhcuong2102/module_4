package com.codegym.furama_resort.repository.employee;

import com.codegym.furama_resort.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from Employee where name like ? and email like ? and division_id like ?", nativeQuery = true)
    Page<Employee> searchEmployee(String name, String email, String divisionId, Pageable pageable);
}
