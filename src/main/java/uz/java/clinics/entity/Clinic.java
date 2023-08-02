package uz.java.clinics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clinic")
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "address",nullable = false)
    private String address;
    @Column(name = "photo_link",nullable = false)
    private String photo_link;
    @Column(name = "call_center",nullable = false)
    private String call_center;
    @Column(name = "is_active",nullable = false)
    private boolean is_active;

}
