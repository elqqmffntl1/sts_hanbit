package com.hanbit.web.grade;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class GradeDAOImpl implements GradeDAO{
	private static final Logger logger = LoggerFactory.getLogger(GradeDAOImpl.class);
	private static final String NAMESPACE = "mapper.grade.";
	private SqlSessionFactory sqlSessionFactory = null;
	public GradeDAOImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	private static GradeDAOImpl instance = new GradeDAOImpl();
	
	public static GradeDAOImpl getInstance() {
		if (instance == null) {
			logger.info("GradeDAOImpl instance is created !!");
			instance = new GradeDAOImpl();
		}
		return instance;
	}
	private GradeDAOImpl() {
		try{
			InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);		
		} catch(IOException e){
			logger.info("session build fail");
		}
	}	
	@Override
	public int insert(GradeVO grade) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.insert("",grade);
	}
	@Override
	public int update(GradeVO grade){
		SqlSession session = sqlSessionFactory.openSession();
		return session.update("",grade);
	}
	@Override
	public int delete(String delete) {
		SqlSession session = sqlSessionFactory.openSession();
		return session.delete("",delete);
	}

	@Override
	public List<GradeVO> list() {
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("");
	}
	@Override
	public GradeVO findBySeq(int seq) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectOne(NAMESPACE + "findBySeq", seq);
		} finally{
			session.close();
		}
	}
	@Override
	public List<GradeVO> findByID(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectOne(NAMESPACE + "findById", id);
		} finally{
			session.close();
		}
	}
	@Override
	public int count(String findByDate){
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("");
	
	}
	
}