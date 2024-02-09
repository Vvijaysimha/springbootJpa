package in.vijay.Springbootjpa.service;

import in.vijay.Springbootjpa.DTO.Employee;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getEmployees();
    Employee saveEmployee(Employee employee);
    Employee getSingleEmployee(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee(Employee employee);
}
