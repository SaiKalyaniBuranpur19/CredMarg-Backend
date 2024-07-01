//package com.credmarg.payment_flow_backend.Open.Controllers;
//
//import com.credmarg.payment_flow_backend.Open.Model.Employee;
//import com.credmarg.payment_flow_backend.Open.Services.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("/api/employees")
//public class EmployeeController {
//    @Autowired
//    private EmployeeService service;
//
//    @GetMapping
//    public List<Employee> getAllEmployees(){
//        return service.getAllEmployees();
//    }
//
//    @PostMapping
//    public Employee addEmployee(@RequestBody Employee employee){
//        Employee employee1 = service.addEmployee(employee);
//        return employee1;
//    }
//}


package com.credmarg.payment_flow_backend.Open.Controllers;

import com.credmarg.payment_flow_backend.Open.Model.Employee;
import com.credmarg.payment_flow_backend.Open.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService service = new EmployeeService();

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }
}
