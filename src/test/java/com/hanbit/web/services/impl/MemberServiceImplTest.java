package com.hanbit.web.services.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.mappers.MemberMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MemberServiceImplTest {
	@Mock private MemberDTO member;
	
	@Configuration
	static class MemberServiceImplTestContextConfiguration{
	@Bean
	public MemberServiceImpl memberService(){
		return new MemberServiceImpl();
	}
	@Bean
	public MemberMapper memberMapper(){
		return Mockito.mock(MemberMapper.class);
	}
	@Autowired private MemberServiceImpl service;
	@Autowired private MemberMapper mapper;
	
	@Before
	public void setUp(){
		ReflectionTestUtils.setField(service, "mapper", mapper);
	}
	@Test
	public void login(MemberDTO member) {
		MemberDTO mem = mapper.findById("reper");
		when(mapper.findById(member.getId())).thenReturn(mem);
		assertEquals(mem.getName(), "리 퍼");
	}
  }
}