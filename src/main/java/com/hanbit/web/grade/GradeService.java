package com.hanbit.web.grade;

import java.sql.SQLException;
import java.util.List;

import com.hanbit.web.util.CommonService;



public interface GradeService extends CommonService{
	// 총 7개의 기본 패턴이 존재
	// exeU
	
	public String insert(GradeBean grade);
	public String update(GradeBean grade);
	public String delete(String delete); 
	public GradeBean findBySeq(int seq);
	public int count (String findByDate);
	public String GradeCal(GradeBean grade);
}