package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.Userdto;
import com.app.entites.User;


public interface IUserRepository extends JpaRepository<User, Long> {
	
	}
