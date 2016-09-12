package com.hanbit.web.services;

import java.sql.SQLException;
import java.util.List;

import com.hanbit.web.domains.GradeDTO;
import com.hanbit.web.util.CommonService;



public interface GradeService extends CommonService{
	// 총 7개의 기본 패턴이 존재
	// exeU
	
	public String insert(GradeDTO grade);
	public String update(GradeDTO grade);
	public String delete(String delete); 
	public GradeDTO findBySeq(int seq);
	public int count (String findByDate);
	public String GradeCal(GradeDTO grade);
}