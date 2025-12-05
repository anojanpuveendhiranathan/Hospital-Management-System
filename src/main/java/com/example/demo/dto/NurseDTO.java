package com.example.demo.dto;
import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NurseDTO {

    // Staff fields
    private String name;
    private LocalDate dob;
    private String email;
    private String contactNo;
    private String gender;   // "M", "F", "O"
    private String shiftTime;
    private String workStatus; // "PARTTIME", "FULLTIME", "PERMANENT"

    // Nurse fields
    private Long specialityId;
    private Integer expOfYears;
    private String qualification;
}