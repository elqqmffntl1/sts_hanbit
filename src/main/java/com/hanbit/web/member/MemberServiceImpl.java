package com.hanbit.web.member;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.bank.AccountService;
import com.hanbit.web.bank.AccountServiceImpl;
import com.hanbit.web.subject.SubjectVO;
import com.hanbit.web.subject.SubjectDAOImpl;
import com.hanbit.web.subject.SubjectMemberVO;
@Service
public class MemberServiceImpl implements MemberService {
	private MemberDAOImpl dao;
	private SubjectDAOImpl subjDao;
	@Autowired private MemberVO member;
	@Autowired private SubjectVO sb;
	@Autowired private SubjectMemberVO sm;

	public MemberServiceImpl() {
		dao = MemberDAOImpl.getInstance();
		subjDao= SubjectDAOImpl.getInstance();
	}

	@Override
	public String regist(MemberVO mem) {
		String msg = "";
		MemberVO temp = this.findById(mem.getId());
		if (temp == null) {
			System.out.println(mem.getId()+"은(는) 사용 가능한 ID 입니다.");
			int result = dao.insert(mem);
			if (result==1) {
				msg = "success";
			} else {
	            msg = "fail";
			}
		}else{
			System.out.println(mem.getId()+"은(는) 사용 불가능한 ID 입니다.");
			msg = "fail";
		}
		return msg;
	}

	@Override
	public String show() {
		// TODO 2.보기
		return member.toString();
	}

	@Override
	public void update(MemberVO mem) {
		// TODO 3.수정
		int result = dao.update(mem);
		if (result == 1) {
			System.out.println("서비스 수정결과 성공");
		}else{
			System.out.println("서비스 수정결과 실패");
		}
	}

	@Override
	public String delete(MemberVO member) {
		// TODO 4.삭제
		String result = "";
		if (dao.delete(member) == 1) {
			result = "삭제성공";
		} else {
            result = "삭제실패";
		}
		return  result;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.count();
	}

	@Override
	public MemberVO findById(String findID) {
		return dao.findById(findID);
	}

	@Override
	public List<?> list() {
		return dao.list();
	}

	@Override
	public List<?> findBy(String keyword) {
		return dao.findByName(keyword);
	}

	@Override
	public Map<?, ?> map() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SubjectMemberVO login(MemberVO member) {
		// 2.로그인
			if (dao.login(member)) {
				member = findById(member.getId());
				System.out.println("서비스 로그인 하는 중..ID"+member.getId());
				//accService.map();
				sb = subjDao.findById(member.getId());
				sm.setEmail(member.getEmail());
				sm.setId(member.getId());
				sm.setImg(member.getProfileImg());
				sm.setName(member.getName());
				sm.setPhone(member.getPhone());
				sm.setPw(member.getPw());
				sm.setReg(member.getRegDate());
				sm.setSsn(member.getSsn());
				sm.setGender(member.getGender());
				sm.setBirth(String.valueOf(member.getBirth()));
				sm.setMajor(sb.getMajor());
				sm.setSubjects(sb.getSubjects());
				System.out.println(sm);
			} else {
				sm.setId("fail");
			}
		System.out.println("서비스로그인결과?"+sm.getId());
		return sm;
	}

	@Override
	public MemberVO getSession() {
		return member;
	}

	@Override
	public void logout(MemberVO member) {
		if (member.getId().equals(member.getId())&&member.getPw().equals(member.getPw())) {
			member = null;
		}
	}

	public static MemberServiceImpl getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

}
/*
 * String sqlCreate = "create table member(" + "id varchar2(20) primary key," +
 * "pw varchar2(20)," + "name varchar2(20)," + "reg_date varchar2(20)," +
 * "ssn varchar2(10)" + ")"; String sqlDrop = "drop table member";
 */