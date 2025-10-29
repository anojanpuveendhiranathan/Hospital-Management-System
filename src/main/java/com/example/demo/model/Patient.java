package com.example.demo.model;

import javax.persistence.*;
import com.example.demo.model.enums.Gender;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id", nullable = false, unique = true)
    private Integer patientId;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "dob")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 10)
    private Gender gender;

    @Column(name = "contact_num", length = 10, nullable = false)
    private String contactNumber;

    @Column(name = "city", length = 15)
    private String city;

    @Column(name = "blood_group", length = 5)
    private String bloodGroup;

    @Column(name = "current_medication", length = 100)
    private String currentMedication;

    @Column(name = "date_of_admission")
    private LocalDateTime dateOfAdmission;

    @Column(name = "date_of_discharge")
    private LocalDateTime dateOfDischarge;

    @Column(name = "billing_amount", precision = 10, scale = 2)
    private BigDecimal billingAmount;

    @Column(name = "room_no", length = 10)
    private String roomNumber;

    @Column(name = "emergency_number", length = 10)
    private String emergencyNumber;

    // Getters and Setters
    public Integer getPatientId() {
        return patientId;
    }
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getCurrentMedication() {
        return currentMedication;
    }
    public void setCurrentMedication(String currentMedication) {
        this.currentMedication = currentMedication;
    }

    public LocalDateTime getDateOfAdmission() {
        return dateOfAdmission;
    }
    public void setDateOfAdmission(LocalDateTime dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public LocalDateTime getDateOfDischarge() {
        return dateOfDischarge;
    }
    public void setDateOfDischarge(LocalDateTime dateOfDischarge) {
        this.dateOfDischarge = dateOfDischarge;
    }

    public BigDecimal getBillingAmount() {
        return billingAmount;
    }
    public void setBillingAmount(BigDecimal billingAmount) {
        this.billingAmount = billingAmount;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }
    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }
}