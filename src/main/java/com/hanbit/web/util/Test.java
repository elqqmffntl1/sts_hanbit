package com.hanbit.web.util;



import com.hanbit.web.domains.GradeDTO;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.services.impl.GradeServiceImpl;
import com.hanbit.web.services.impl.MemberServiceImpl;

public class Test {
	public String test(){
		MemberDTO m = MemberServiceImpl.getInstance().findById("hong");
		return m.getName();
	}
	public static void main(String[] args){
		Test t = new Test();
		System.out.println("member test : "+t.test());
	}
}
