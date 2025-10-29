package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import com.example.demo.model.enums.Gender;
import com.example.demo.model.enums.WorkStatus;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "specialization", length = 60, nullable = false)
    private String specialization;

    @Column(name = "patients_treated")
    private Integer patientsTreated;

    @Column(name = "experience_years")
    private Integer experienceYears;

    @Column(name = "dob")
    private LocalDate dateOfBirth;

    @Column(name = "email_id", length = 30, unique = true)
    private String emailId;

    @Column(name = "contact_no", length = 10, nullable = false)
    private String contactNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 10)
    private Gender gender;

    @Column(name = "qualification", length = 200)
    private String qualification;

    @Column(name = "shift_time", length = 70)
    private String shiftTime;

    @Column(name = "profile_photo", length = 50)
    private String profilePhoto;

    @Enumerated(EnumType.STRING)
    @Column(name = "work_status", length = 20)
    private WorkStatus workStatus;

    // Getters and Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Integer getPatientsTreated() {
        return patientsTreated;
    }
    public void setPatientsTreated(Integer patientsTreated) {
        this.patientsTreated = patientsTreated;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }
    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getShiftTime() {
        return shiftTime;
    }
    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }
    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public WorkStatus getWorkStatus() {
        return workStatus;
    }
    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
    }
}