package uz.java.clinics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
