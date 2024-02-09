package in.vijay.Springbootjpa.service;

import in.vijay.Springbootjpa.DTO.Employee;
import in.vijay.Springbootjpa.Repository.Employeerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private Employeerepo employeerepo;

    @Override
    public List<Employee> getEmployees() {
        return employeerepo.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeerepo.save(employee);
    }

    @Override
    public Employee getSingleEmployee(Long id) {
        Optional <Employee> employee=employeerepo.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        throw new RuntimeException("employee record not found for this id"+id);
    }

    @Override
    public void deleteEmployee(Long id) {
       employeerepo.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeerepo.save(employee);
    }
}
