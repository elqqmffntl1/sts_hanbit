package com.hanbit.web.grade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/grade")
public class GradeController {
	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);
	@RequestMapping("/main")
	public String moveMain(){
		logger.info("GradeController ! moveMain() ");
		return "user:grade/content.tiles";
	}
	@RequestMapping("/count")
	public String moveCount(){
		logger.info("GradeController ! count() ");
		return "public:grade/count.tiles";
	}
	@RequestMapping("/delete")
	public String moveDelete(){
		logger.info("GradeController ! delete() ");
		return "user:grade/delete.tiles";
	}
	@RequestMapping("/list")
	public String moveList(){
		logger.info("GradeController ! list() ");
		return "public:grade/list.tiles";
	}
	@RequestMapping("/regist")
	public String moveRegist(){
		logger.info("GradeController ! regist() ");
		return "public:grade/regist.tiles";
	}
	@RequestMapping("/search")
	public String moveSearch(){
		logger.info("GradeController ! search() ");
		return "public:grade/search.tiles";
	}
	@RequestMapping("/update")
	public String moveUpdate(){
		logger.info("GradeController ! update() ");
		return "user:grade/update.tiles";
	}
}
