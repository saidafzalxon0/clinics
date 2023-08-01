package uz.java.clinics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    private Long id;
    @Column(name = "first_name",nullable = false)
    private String first_name;
    @Column(name = "last_name",nullable = false)
    private String last_name;
    @Column(name = "phone_number",nullable = false)
    private String phone_number;
    @Column(name = "photo_link",nullable = false)
    private String photo_link;
    @JoinColumn(name = "clinic_id",nullable = false)
    @ManyToOne
    private Clinic clinic;
    @JoinColumn(name = "service_id",nullable = false)
    @ManyToOne
    private Service service;
    @Column(name = "work_time",nullable = false)
    private String work_time;
    @Column(name = "room_no",nullable = false)
    private Integer room_no;
    @Column(name = "qualification_year",nullable = false)
    private Integer qualification_year;
}
