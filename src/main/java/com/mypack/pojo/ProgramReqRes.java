package com.mypack.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProgramReqRes {

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
