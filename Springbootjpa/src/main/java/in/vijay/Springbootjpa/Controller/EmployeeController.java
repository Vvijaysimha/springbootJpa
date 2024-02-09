package in.vijay.Springbootjpa.Controller;

import in.vijay.Springbootjpa.DTO.Employee;
import in.vijay.Springbootjpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/emp/{id}")
    public Employee getSingleEmployee(@PathVariable long id){
        return employeeService.getSingleEmployee(id);

    }

    @PostMapping("/Employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);

    }


    @DeleteMapping("/employee")
    public void detleteEmployee(@RequestParam long id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/EmployeeDetails")
    public String getEpmloyeedetails(){
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("vijay");
        arrayList.add("kiran");
        return arrayList.get(1);
    }

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable long id,@RequestBody Employee employee){
        employee.setId(id);
        return employeeService.updateEmployee(employee);

    }



}
