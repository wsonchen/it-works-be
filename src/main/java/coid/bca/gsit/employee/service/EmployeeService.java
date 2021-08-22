package coid.bca.gsit.employee.service;

import coid.bca.gsit.employee.model.Employee;
import coid.bca.gsit.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        List<Employee> employees = repository.findAll();
        return employees;
    }

    public Optional<Employee> getEmployeeById(long id) {
        Optional<Employee> employee = repository.findById(id);
        return employee;
    }
}
