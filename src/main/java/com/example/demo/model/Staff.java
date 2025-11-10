package com.example.demo.model;


import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate dob;

    @Column(length = 150, unique = true)
    private String email;

    @Column(length = 20)
    private String contactNo;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String shiftTime;
    private String profilePhoto;

    @Enumerated(EnumType.STRING)
    private WorkStatus workStatus;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }
    @PreUpdate
    public void preUpdate() { updatedAt = LocalDateTime.now(); }

    public enum Gender { M, F, O }
    public enum WorkStatus { PARTTIME, FULLTIME, PERMANENT }
}