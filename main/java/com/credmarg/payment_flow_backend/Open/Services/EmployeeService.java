package com.credmarg.payment_flow_backend.Open.Services;

import com.credmarg.payment_flow_backend.Open.Model.Employee;
import com.credmarg.payment_flow_backend.Open.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
}

