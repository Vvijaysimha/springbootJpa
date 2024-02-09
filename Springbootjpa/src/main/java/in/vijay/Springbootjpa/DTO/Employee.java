package in.vijay.Springbootjpa.DTO;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name="tbl_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message="name should not be null")
    private  String name;
    private  Long age;
    private String location;
    @Email(message = "please enter valid email address")
    private String email;
    @NotEmpty(message = "department should not null")
    private String department;

    @CreationTimestamp
    @Column(name ="created_at",nullable = false,updatable = false)
    private Date CreatedAt;

    @UpdateTimestamp
    @Column(name ="updated_at")
    private Date UpdatedAt;

    public Employee() {
    }

    public Employee(long id, String name, Long age, String location, String email, String department, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.location = location;
        this.email = email;
        this.department = department;
        CreatedAt = createdAt;
        UpdatedAt = updatedAt;
    }
}
