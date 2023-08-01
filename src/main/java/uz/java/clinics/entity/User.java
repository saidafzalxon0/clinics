package uz.java.clinics.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "User")
public class User {

    @Id
    private Long id;
    @Column(name = "first_name",nullable = false)
    private String first_name;
    @Column(name = "last_name",nullable = false)
    private String  last_name;
    @Column(name = "age",nullable = false)
    private Long age;
    @Column(name = "phone_number",nullable = false)
    private String phone_number;
}
