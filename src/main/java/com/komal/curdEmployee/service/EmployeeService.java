package com.komal.curdEmployee.service;

import com.komal.curdEmployee.dao.Employee;
import com.komal.curdEmployee.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepo.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepo.saveAndFlush(employee);
    }

    public Employee updateEmployee(Employee employee, Long id) {
        if(employeeRepo.existsById(id)) {
            return employeeRepo.saveAndFlush(employee);
        } else {
            throw new RuntimeException("Given id is not belongs to Employee");
        }
    }

    public String deleteEmployeeById(Long id) {
        employeeRepo.deleteById(id);
        return "Employee deleted Successfully";
    }

    public String deleteAllEmployee() {
        employeeRepo.deleteAll();
        return "All Employee Deleted Successfully";
    }
}
