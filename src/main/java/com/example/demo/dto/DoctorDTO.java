package com.example.demo.dto;
import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorDTO {
    // Staff fields
    private String name;
    private LocalDate dob;
    private String email;
    private String contactNo;
    private String gender; // "M", "F", "O"
    private String shiftTime;
    private String workStatus; // "PARTTIME", "FULLTIME", "PERMANENT"

    // Doctor fields
    private Long specialityId;
    private Integer patientsTreated;
    private Integer expOfYears;
    private String qualification;
}
