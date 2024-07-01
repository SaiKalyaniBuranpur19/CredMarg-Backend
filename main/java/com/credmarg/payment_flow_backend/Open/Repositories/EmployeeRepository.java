package com.credmarg.payment_flow_backend.Open.Repositories;

import com.credmarg.payment_flow_backend.Open.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    }

