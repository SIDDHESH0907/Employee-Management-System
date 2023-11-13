package com.ems.models;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int P_id;

	@Size(min = 3, max = 30, message = "Name must be between 3 to 30 characters")
	@NotNull(message = "Job Role Name must not be Empty")
	@Column(nullable = false)
	String project_name;

	@Column(nullable = false)
	String technology;

	@ManyToMany(mappedBy = "project")
	private List<employee> employee;

	@CreatedDate
	Instant createdAt;

	@LastModifiedDate
	Instant updatedAt;

}
