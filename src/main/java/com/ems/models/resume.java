package com.ems.models;



import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class resume {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		
		@Column(nullable=false)
		private String name;
		
		@Column(nullable=false)
		private String education;
		
		@Column(nullable=false)
		private String skills;
		
		@Column(nullable=false)
		private int experience;
		
		@OneToOne(mappedBy = "resume")
		@JsonIgnore
		private employee employee;

	}

