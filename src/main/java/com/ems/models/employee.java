package com.ems.models;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emp_id;

	@Size(min = 3, max = 30, message = "Name must be between 3 to 30 characters")
	@NotNull(message = "Name must not be Empty")
	@Column(nullable = false, unique = false)
	private String name;

	@Size(min = 3, max = 15, message = "City must be between 3 to 15 characters")
	@NotNull(message = "City must not be Empty")
	@Column(nullable = false, unique = false)
	private String city;

	@Min(value = 0, message = "Salary cant be zero")
	@Max(value = 500000, message = "Max salary 500000")
	@NotNull(message = "Salary must not be Empty")
	@Column(nullable = false, unique = false)
	private int salary;

	@NotNull(message = "Gender must not be Empty")
	@Column(nullable = false)
	private char gender;

	@OneToOne
	@JoinColumn(name = "resume_id")
	private resume resume;

	@OneToMany(mappedBy = "employee")
	private List<department> department;

	@ManyToMany
	private List<project> project;

	@CreatedDate
	private Instant createdAt;

	@LastModifiedDate
	private Instant updatedAt;

}