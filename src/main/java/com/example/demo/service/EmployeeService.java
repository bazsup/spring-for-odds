package com.example.demo.service;

import com.example.demo.UnProcessableException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LogRepository logRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.listAll();
    }

    public Employee getEmployee(Integer id) {
        return employeeRepository.getById(id);
    }

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Integer id, Employee employee) {
        Employee employeeEntity = employeeRepository.getById(id);
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());

//        logRepository.saveLog();

        employeeRepository.save(employee);
//        throw new RuntimeException("force error to show");
    }

    @Transactional
    public void deleteEmployee(Integer id) {
        Employee employeeEntity = employeeRepository.getById(id);
        if (employeeEntity == null) {
            throw new UnProcessableException("employee not found");
        }
        employeeRepository.delete(employeeEntity);
//        employeeRepository.rem
    }
}
