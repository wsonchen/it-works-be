package coid.bca.gsit.employee.service;

import coid.bca.gsit.employee.model.Employee;
import coid.bca.gsit.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
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

    public void createEmployee(Employee employee) {
        Optional<Employee> exist = repository.findByEmail(employee.getEmail());
        if (exist.isPresent()) {
            throw new EntityExistsException("Email already registered!");
        }
        repository.save(employee);
    }

    public void updateEmployee(Employee update) {
        Optional<Employee> exist = repository.findById(update.getId());
        if (!exist.isPresent()) {
            throw new EntityNotFoundException("Employee not found!");
        }
        Employee current = exist.get();
        current.setName(update.getName());
        current.setEmail(update.getEmail());
        repository.save(current);
    }
}
