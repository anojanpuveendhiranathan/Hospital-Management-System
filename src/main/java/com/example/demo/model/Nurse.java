package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nurse")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nurse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "staff_id", nullable = false)
	private Staff staff;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "speciality_id")
	private Speciality speciality;


	private Integer expOfYears;

	@Column(length = 500)
	private String qualification;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@PrePersist
	public void prePersist() {
		createdAt = LocalDateTime.now();
		updatedAt = createdAt;
	}

	@PreUpdate
	public void preUpdate() {
		updatedAt = LocalDateTime.now();
	}
}
