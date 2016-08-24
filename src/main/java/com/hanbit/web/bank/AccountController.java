package com.hanbit.web.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/account")
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	@RequestMapping("/main")
	public String moveMain(){
		logger.info("AccountController ! moveMain() ");
		return "user:account/content.tiles";
	}
	@RequestMapping("/count")
	public String moveCount(){
		logger.info("AccountController ! count() ");
		return "public:account/count.tiles";
	}
	@RequestMapping("/delete")
	public String moveDelete(){
		logger.info("AccountController ! delete() ");
		return "user:account/delete.tiles";
	}
	@RequestMapping("/deposit")
	public String moveDeposit(){
		logger.info("AccountController ! deposit() ");
		return "user:account/deposit.tiles";
	}
	@RequestMapping("/list")
	public String moveList(){
		logger.info("AccountController ! list() ");
		return "public:account/list.tiles";
	}
	@RequestMapping("/regist")
	public String moveRegist(){
		logger.info("AccountController ! regist() ");
		return "public:account/regist.tiles";
	}
	@RequestMapping("/search")
	public String moveSearch(){
		logger.info("AccountController ! search() ");
		return "public:account/search.tiles";
	}
	@RequestMapping("/update")
	public String moveUpdate(){
		logger.info("AccountController ! update() ");
		return "user:account/update.tiles";
	}
	@RequestMapping("/withdraw")
	public String moveWithdraw(){
		logger.info("AccountController ! withdraw() ");
		return "user:account/withdraw.tiles";
	}

}
