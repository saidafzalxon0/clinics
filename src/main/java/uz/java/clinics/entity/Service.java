package uz.java.clinics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "clinic_id",nullable = false)
    @ManyToOne
    private Clinic clinic;
    @Column(name = "service_name",nullable = false)
    private String service_name;
    @Column(name = "service_price",nullable = false)
    private Double service_price;

}
