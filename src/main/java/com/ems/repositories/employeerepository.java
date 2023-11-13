package com.ems.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ems.models.employee;


public interface employeerepository extends CrudRepository<employee, Integer> {
	


}
