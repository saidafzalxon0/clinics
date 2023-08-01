package uz.java.clinics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "work_day")
public class Work_day {
    @Id
    private Long id;
    @JoinColumn(name = "doctor_id",nullable = false)
    @OneToOne
    private Doctor doctor_id;
    @Column(name = "monday",nullable = false)
    private boolean monday;
    @Column(name = "tuesday",nullable = false)
    private boolean tuesday;
    @Column(name = "wednesday",nullable = false)
    private boolean wednesday;
    @Column(name = "thursday",nullable = false)
    private boolean thursday;
    @Column(name = "friday",nullable = false)
    private boolean friday;
    @Column(name = "saturday",nullable = false)
    private boolean saturday;
}
