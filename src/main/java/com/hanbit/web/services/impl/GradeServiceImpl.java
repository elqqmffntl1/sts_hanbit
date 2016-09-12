package com.hanbit.web.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hanbit.web.domains.GradeDTO;
import com.hanbit.web.services.GradeService;
@Service
public class GradeServiceImpl implements GradeService{

	
	private static GradeServiceImpl instance = new GradeServiceImpl();
	private GradeServiceImpl() {}
	public static GradeServiceImpl getInstance() {
		return instance;
	}

	@Override
	public String GradeCal(GradeDTO grade) {
		String gradeRank ="";
		int sum = grade.getJava() + grade.getSql() + grade.getHtml() + grade.getJavascript();
		int ave = sum / 4;
		switch (ave/10) {
		case 9:	gradeRank = "A";break;
		case 8:	gradeRank = "B";break;
		case 7:	gradeRank = "C";break;
		case 6:	gradeRank = "D";break;
		case 5:	gradeRank = "F";break;
		}
		return gradeRank;
	}
	
	
	@Override
	public String insert(GradeDTO grade) {
		String insert = "";
		grade.setGrade(this.GradeCal(grade));
		return insert;
	}

	@Override
	public String update(GradeDTO grade) {
		String update = "";

		return update;
	}

	@Override
	public String delete(String delete) {
		String result ="";

		return result;
	}

	@Override
	public List<?> list() {
		return null;
	}

	@Override
	public List<?> findBy(String id) {
		return null;
	}

	
	@Override
	public GradeDTO findBySeq(int seq) {
		return null;
	}

	@Override
	public int count(String findByCount) {
		return 0;
	}

	@Override
	public Map<?, ?> map() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}