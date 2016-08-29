package com.hanbit.web.grade;

import java.sql.SQLException;
import java.util.List;

import com.hanbit.web.util.CommonService;



public interface GradeService extends CommonService{
	// 총 7개의 기본 패턴이 존재
	// exeU
	
	public String insert(GradeVO grade);
	public String update(GradeVO grade);
	public String delete(String delete); 
	public GradeVO findBySeq(int seq);
	public int count (String findByDate);
	public String GradeCal(GradeVO grade);
}