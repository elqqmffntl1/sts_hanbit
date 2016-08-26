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
		return "admin:account/content.tiles";
	}
	@RequestMapping("/count")
	public String moveCount(){
		logger.info("AccountController ! count() ");
		return "admin:account/count.tiles";
	}
	@RequestMapping("/delete")
	public String moveDelete(){
		logger.info("AccountController ! delete() ");
		return "admin:account/delete.tiles";
	}
	@RequestMapping("/deposit")
	public String moveDeposit(){
		logger.info("AccountController ! deposit() ");
		return "user:account/deposit.tiles";
	}
	@RequestMapping("/list")
	public String moveList(){
		logger.info("AccountController ! list() ");
		return "admin:account/list.tiles";
	}
	@RequestMapping("/open")
	public String moveOpen(){
		logger.info("AccountController ! open() ");
		return "admin:account/open.tiles";
	}
	@RequestMapping("/find")
	public String moveFind(){
		logger.info("AccountController ! find() ");
		return "admin:account/find.tiles";
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
