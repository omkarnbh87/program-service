package com.mypack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypack.entities.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {
	
	Program getProgramById(int id);
}

