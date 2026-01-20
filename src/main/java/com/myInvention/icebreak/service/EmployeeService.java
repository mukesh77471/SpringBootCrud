package com.myInvention.icebreak.service;

import com.myInvention.icebreak.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
