package com.hanbit.web.services;

import java.util.List;
import java.util.Map;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.util.CommonService;



/**
 * @date : 2016. 6. 17.
 * @author : 한상호
 * @file : StudentService.java
 * @story :
 */
public interface MemberService{
	public String regist(MemberDTO mem);
	public String show();
	public void update(MemberDTO stu2);
	public void delete(MemberDTO member);
	public MemberDTO findOne(Command command);
	public MemberDTO getSession();
	public void logout(MemberDTO member);
	public MemberDTO login(MemberDTO member);
	public List<?> findBy(String keyword);
	public List<?> list();
	public int count();
	public Map<?, ?> map();
}
