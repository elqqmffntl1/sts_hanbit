package com.hanbit.web.member;

import java.util.List;

import com.hanbit.web.subject.SubjectMemberVO;
import com.hanbit.web.util.CommonService;



/**
 * @date : 2016. 6. 17.
 * @author : 한상호
 * @file : StudentService.java
 * @story :
 */
public interface MemberService extends CommonService{
	public String regist(MemberVO mem);
	public String show();
	public void update(MemberVO stu2);
	public String delete(MemberVO member);
	public MemberVO findById(String findID);
	public SubjectMemberVO login(MemberVO member); 
	public MemberVO getSession();
	public void logout(MemberVO member);
}
