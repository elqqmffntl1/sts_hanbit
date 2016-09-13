package com.hanbit.web.domains;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @date   : 2016. 7. 26.
 * @author : 한상호
 * @file   : SubjectBean.java
 * @story  :
*/
@Component
@Data
public class BoardDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	@Getter @Setter	private int artSeq;
	@Getter @Setter	private String id,pw,name,gender,writeDate,ssn,email,profileImg,role,phone,category,title,regDate,content;
}
