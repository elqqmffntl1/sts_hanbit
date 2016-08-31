package com.hanbit.web.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hanbit.web.subject.SubjectMemberVO;


@Controller
@SessionAttributes("user")
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberService service;
	
	@RequestMapping("/search")
	public String find(@RequestParam("keyword") String keyword,
			@RequestParam("search_option") String option,
			@RequestParam("context") String context,
			Model model){
		logger.info("MemberController ! findById : {}","??");
		System.out.println("검색어:"+keyword);
		System.out.println("옵션:"+option);
		System.out.println("context :"+context);
		MemberVO member = (MemberVO) service.findById(keyword);
		System.out.println("NAME : "+ member.getName());
		System.out.println("profileImg : "+ member.getProfileImg());
		model.addAttribute("member", member);
		model.addAttribute("img", context+"/resources/img");
		return "admin:member/detail.tiles";
				
	}
	@RequestMapping("/login/execute")
	public String executeLogin(@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("context") String context,
			Model model) {
		logger.info("MemberController ! loginExecute : {}","??");
		System.out.println("로그인시 넘어온 id :"+id);
		System.out.println("로그인시 넘어온 pw :"+pw);
		System.out.println("context :"+context);
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPw(pw);
		SubjectMemberVO sm = service.login(member);
		model.addAttribute("user",sm);
		model.addAttribute("js",context+"/resources/js");
		model.addAttribute("css",context+"/resources/css");
		model.addAttribute("img",context+"/resources/img");
		return "user:user/content.tiles";
	} 
	// --- MOVE ---
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
		return "admin:member/detail.tiles";
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
