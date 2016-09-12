package com.hanbit.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/grade")
public class GradeController {
	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);
	@RequestMapping("/main")
	public String moveMain(){
		logger.info("GO TO {}","main");
		return "user:grade/content.tiles";
	}
	@RequestMapping("/count")
	public String moveCount(){
		logger.info("GO TO {}","count");
		return "admin:grade/count.tiles";
	}
	@RequestMapping("/delete")
	public String moveDelete(){
		logger.info("GO TO {}","delete");
		return "admin:grade/delete.tiles";
	}
	@RequestMapping("/list")
	public String moveList(){
		logger.info("GO TO {}","list");
		return "admin:grade/list.tiles";
	}
	@RequestMapping("/regist")
	public String moveRegist(@RequestParam("key") String key){
		logger.info("GO TO {}","regist");
		logger.info("KEY IS {}",key);
		return "admin:grade/regist.tiles";
	}
	@RequestMapping("/find")
	public String moveFind(){
		logger.info("GO TO {}","search");
		return "user:grade/find.tiles";
	}
	@RequestMapping("/update")
	public String moveUpdate(@RequestParam("key") String key){
		logger.info("GO TO {}","update");
		logger.info("KEY IS {}",key);
		return "admin:grade/update.tiles";
	}
	@RequestMapping("/detail")
	public String moveDetail(){
		logger.info("GO TO {}","detail");
		return "user:grade/detail.tiles";
	}
}
