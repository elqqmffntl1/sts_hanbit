package com.hanbit.web.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.hanbit.web.domains.Command;
import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.domains.Retval;
import com.hanbit.web.services.MemberService;

@Controller
@SessionAttributes({"user","context","js","css","img"})
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberService service;
	@Autowired Command command;
	@Autowired MemberDTO member;
	@Autowired Retval retval;
	@RequestMapping("/search/{option}/{keyword}")
	public MemberDTO find(@PathVariable("option") String option,
			@PathVariable("keyword") String keyword,
			Model model){
		logger.info("keyword IS {}",keyword);
		logger.info("option IS {}",option);
		command.setKeyword(keyword);
		command.setOption(option);
		return service.findOne(command);
	}
	@RequestMapping(value="/count/{option}")
	public Model count(@PathVariable("option") String option,Model model){
		logger.info("TO COUNT CONDITION IS {}",option);
		model.addAttribute("count", service.count());
		return model;
	}
	@RequestMapping("/logined/header")
	public String loginedHeader(){
		logger.info("TO PATH IS {}","LOGINED_HEADER");
		return "user/header.jsp";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody MemberDTO login(@RequestParam("id") String id,
			@RequestParam("pw") String pw, HttpSession session) {
		logger.info("TO LOGIN ID IS {}",id);
		logger.info("TO LOGIN PW IS {}",pw);
		member.setId(id);
		member.setPw(pw);
		MemberDTO user = service.login(member);
		if(user.getId().equals("NONE")){
			logger.info("Controller LOGIN ","FAIL");
			return user;
		}else{
			logger.info("Controller LOGIN ","SUCCESS");
			session.setAttribute("user", user);
			return user;
		}
	} 
	// --- MOVE ---
	@RequestMapping("/main")
	public String moveMain() {
		logger.info("GO TO {}","main");
		return "user:member/content.tiles";
	} 
	@RequestMapping("/signup")
	public @ResponseBody Retval signup() {
		logger.info("SIGN UP {}","EXEUTE");
		return retval;
	} 
	@RequestMapping("/check_dup/{id}")
	public @ResponseBody Retval CheckDup(@PathVariable String id) {
		logger.info("CHECK DUP {}","EXEUTE");
		if (service.existId(id)==1) {
			retval.setFlag("TRUE");
			retval.setMessage("존재하는 ID 입니다.");
		} else {
			retval.setFlag("FALSE");
			retval.setMessage("새로운 영웅은 언제나 환영이야!");
		}
		logger.info("RETVAL IS {}",retval.getFlag());
		logger.info("RETVAL IS {}",retval.getMessage());
		return retval;
	} 
	@RequestMapping("/login")
	public String Login() {
		logger.info("GO TO {}","login");
		return "public:member/login.tiles";
	} 
	@RequestMapping("/logout")
	public String logout(SessionStatus status) {
		logger.info("GO TO {}","logout");
		status.setComplete();
		logger.info("SESSION IS {}","CLEAR");
		return "redirect:/";
	} 
	@RequestMapping("/a_detail")
	public String moveDetail(@RequestParam("key") String key) {
		logger.info("GO TO {}","a_detail");
		logger.info("KEY IS {}",key);
		return "admin:member/a_detail.tiles";
	} 
	@RequestMapping("/detail")
	public String moveDetail() {
		logger.info("GO TO {}","detail");
		return "user:member/detail.tiles";
	} 
	@RequestMapping("/update")
	public String moveUpdate() {
		logger.info("GO TO {}","update");
		return "user:member/update.tiles";
	} 
	@RequestMapping("/delete")
	public String moveDelete() {
		logger.info("GO TO {}","delete");
		return "user:member/delete.tiles";
	} 
	@RequestMapping("/list")
	public String moveList() {
		logger.info("GO TO {}","list");
		return "admin:member/list.tiles";
	} 
	@RequestMapping("/find")
	public String moveFindBy() {
		logger.info("GO TO {}","find");
		return "admin:member/find_by.tiles";
	} 
	@RequestMapping("/count")
	public String moveCount() {
		logger.info("GO TO {}","count");
		return "admin:member/count.tiles";
	} 
	@RequestMapping("/kaup")
	public String moveKaup() {
		logger.info("GO TO {}","kaup");
		return "user:user/kaup.tiles";
	} 
	@RequestMapping("/rock_sissor_paper")
	public String moveRockSissorPaper() {
		logger.info("GO TO {}","rock_sissor_paper");
		return "user:user/rock_sissor_paper.tiles";
	} 
	@RequestMapping("/lotto")
	public String moveLotto() {
		logger.info("GO TO {}","lotto");
		return "user:user/lotto.tiles";
	} 
	@RequestMapping("/content")
	public String moveContent() {
		logger.info("GO TO {}","content");
		return "user:user/content.tiles";
	}
}
