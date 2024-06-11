package com.mypack.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "programs")
public class Program {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	private Double price;

	private String domain;

	private String programType;

	private String registrations;

	private String description;

	private String placementAssurance;

	private String imageUrl;

	private String universityName;

	private String facultyProfile;

	private String learningHoursAndDuration;

	private String certificateOrDiploma;

	private String eligibilityCriteria;

}
