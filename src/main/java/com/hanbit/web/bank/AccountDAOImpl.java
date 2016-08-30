package com.hanbit.web.bank;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
	private static final Logger logger = LoggerFactory.getLogger(AccountDAOImpl.class);
	private static final String NAMESPACE = "mapper.account.";
	private SqlSessionFactory sqlSessionFactory = null;
	public AccountDAOImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	private static AccountDAOImpl instance = new AccountDAOImpl();
	
	public static AccountDAOImpl getInstance() {
		if (instance == null) {
			logger.info("AccountDAOImpl instance is created !!");
			instance = new AccountDAOImpl();
		}
		return instance;
	}
	private AccountDAOImpl() {
		try{
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);		
		} catch(IOException e){
			logger.info("session build fail");
		}
	}
	@Override
	public int insertAccount(AccountVO acc) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.insert("",acc);
	}
	@Override
	public int selectMoney(int accNo) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectOne(NAMESPACE + "findById", accNo);
		} finally{
			session.close();
		}
	}
	@Override
	public void deposit(AccountVO acc) {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("",acc);
	}
	@Override
	public void withdraw(AccountVO acc) {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("",acc);
	}
	@Override
	public int delete(String delete) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.delete("",delete);
	}
	@Override
	public List<AccountVO> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("");
	}
	@Override
	public int count() {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectOne(NAMESPACE+"count");
		} finally{
			session.close();
		}
	}
	@Override
	public Map<?, ?> selectMap() {
		 return null;
	}
}