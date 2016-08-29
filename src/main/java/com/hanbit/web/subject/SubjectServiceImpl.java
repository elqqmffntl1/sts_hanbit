package com.hanbit.web.subject;

public class SubjectServiceImpl implements SubjectService{
	SubjectDAO dao = SubjectDAO.getInstance();
	private static SubjectServiceImpl instance = new SubjectServiceImpl();
	
	public static SubjectServiceImpl getInstance() {
		return instance;
	}
	private SubjectServiceImpl() {
	}
	@Override
	public void insert(SubjectVO s) {
		dao.insert(s);
	}
}
