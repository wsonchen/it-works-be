package coid.bca.gsit.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping
    public ResponseEntity<?> getAllEmployees() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello World!");
    }
}
