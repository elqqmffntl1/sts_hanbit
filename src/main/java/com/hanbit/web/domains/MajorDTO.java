package com.hanbit.web.domains;


import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @date   :2016. 6. 16. 
 * @author :한상호
 * @file   :Student.java
 * @story  :
*/
@Component
@Data
public class MajorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	@Getter @Setter	private String id,pw,name,regDate,gender,ssn,profileImg,email,phone,role,majorTitle;
	@Getter @Setter	private int majorSeq;
	
}