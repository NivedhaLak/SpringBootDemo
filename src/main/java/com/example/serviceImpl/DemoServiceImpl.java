package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.TestRepository;
import com.example.service.DemoService;
import com.example.vo.Test;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	TestRepository testRepository;

	@Override
	public List<Test> getAll() {
		return testRepository.findAll();
	}
}
