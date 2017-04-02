package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vo.Test;

public interface TestRepository extends JpaRepository<Test, Long> {
	
}
