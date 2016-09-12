package com.hanbit.web.services;

import java.util.List;

import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.util.CommonService;



/**
 * @date : 2016. 6. 17.
 * @author : 한상호
 * @file : StudentService.java
 * @story :
 */
public interface MemberService extends CommonService{
	public String regist(MemberDTO mem);
	public String show();
	public void update(MemberDTO stu2);
	public void delete(MemberDTO member);
	public MemberDTO findById(String findID);
	public MemberDTO getSession();
	public void logout(MemberDTO member);
	public MemberDTO login(MemberDTO member);
}
