package com.hanbit.web.util;



import com.hanbit.web.bank.AccountServiceImpl;
import com.hanbit.web.grade.GradeServiceImpl;
import com.hanbit.web.grade.GradeVO;
import com.hanbit.web.member.MemberServiceImpl;
import com.hanbit.web.member.MemberVO;

public class Test {
	public String test(){
		MemberVO m = MemberServiceImpl.getInstance().findById("hong");
		return m.getName();
	}
	public int test2(){
		int a = AccountServiceImpl.getInstance().count();
		return a;
	}
	public String test3(){
		GradeVO a = GradeServiceImpl.getInstance().findBySeq(1002);
		return a.getSeq();
	}

	public static void main(String[] args){
		Test t = new Test();
		System.out.println("member test : "+t.test());
		System.out.println("account test : "+t.test2());
		System.out.println("grade test : "+t.test3());

	}
	
}
