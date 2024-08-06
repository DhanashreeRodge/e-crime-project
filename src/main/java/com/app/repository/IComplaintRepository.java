package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entites.Complaint;


public interface IComplaintRepository extends JpaRepository<Complaint, Long> {
	
	}
