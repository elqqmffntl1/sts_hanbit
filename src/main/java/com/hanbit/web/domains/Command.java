package com.hanbit.web.domains;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class Command implements Serializable{
	private static final long serialVersionUID = 1L;
	@Getter @Setter	private String option,keyword;
}
