package com.hanbit.web.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@RequestMapping("/main")
	public String moveMain() {
		logger.info("MemberController ! moveMain() ");
		return "user:member/content.tiles";
	} 
	@RequestMapping("/regist")
	public String moveRegist() {
		logger.info("MemberController ! regist() ");
		return "public:member/regist.tiles";
	} 
	@RequestMapping("/login")
	public String moveLogin() {
		logger.info("MemberController ! login() ");
		return "public:member/login.tiles";
	} 
	@RequestMapping("/logout")
	public String moveLogout() {
		logger.info("MemberController ! logout() ");
		return "user:member/logout.tiles";
	} 
	@RequestMapping("/detail")
	public String moveDetail() {
		logger.info("MemberController ! detail() ");
		return "user:member/detail.tiles";
	} 
	@RequestMapping("/update")
	public String moveUpdate() {
		logger.info("MemberController ! update() ");
		return "user:member/update.tiles";
	} 
	@RequestMapping("/delete")
	public String moveDelete() {
		logger.info("MemberController ! delete() ");
		return "user:member/delete.tiles";
	} 
	@RequestMapping("/list")
	public String moveList() {
		logger.info("MemberController ! list() ");
		return "admin:member/list.tiles";
	} 
	@RequestMapping("/find")
	public String moveFindBy() {
		logger.info("MemberController ! find_by() ");
		return "admin:member/find_by.tiles";
	} 
	@RequestMapping("/count")
	public String moveCount() {
		logger.info("MemberController ! count() ");
		return "admin:member/count.tiles";
	} 
	
}
