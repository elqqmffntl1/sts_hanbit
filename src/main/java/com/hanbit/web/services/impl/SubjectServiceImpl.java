package com.hanbit.web.services.impl;

import org.springframework.stereotype.Service;

import com.hanbit.web.domains.SubjectDTO;
import com.hanbit.web.services.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{
	private static SubjectServiceImpl instance = new SubjectServiceImpl();
	
	public static SubjectServiceImpl getInstance() {
		return instance;
	}
	private SubjectServiceImpl() {
	}
	@Override
	public void insert(SubjectDTO s) {
		
	}
}
