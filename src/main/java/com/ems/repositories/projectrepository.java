package com.ems.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ems.models.employee;
import com.ems.models.project;

public interface projectrepository extends CrudRepository<project, Integer>{
	


}
