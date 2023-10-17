package com.event.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	
}
