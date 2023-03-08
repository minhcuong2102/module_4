package com.codegym.furama_resort.repository.employee;

import com.codegym.furama_resort.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationDegreeRepository extends JpaRepository<EducationDegree, Integer> {
}
