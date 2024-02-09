package in.vijay.Springbootjpa.Repository;

import in.vijay.Springbootjpa.DTO.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employeerepo extends JpaRepository<Employee,Long> {



}
