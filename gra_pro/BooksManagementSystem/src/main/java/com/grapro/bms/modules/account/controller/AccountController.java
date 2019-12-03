package com.grapro.bms.modules.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.grapro.bms.modules.account.entity.User;
import com.grapro.bms.modules.account.service.AccountService;
import com.grapro.bms.modules.common.vo.SearchVo;

/**
 * 账户相关控制器
 * 
 */

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	/**
	 * 跳转到user list 页面
	 */
	@RequestMapping("/userListPage")
	public String userListPage(ModelMap modelMap) {
		//modelMap.addAttribute("userList",accountService.getUserList());
		return "account/userList";
	}
	
	/**
	 * 获取users列表
	 */
	@PostMapping(value="/users", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public PageInfo<User> users(@ModelAttribute SearchVo userSearch) {
		return accountService.getUserList(userSearch);
	}
	
	/**
	 * 跳转edit user页面
	 */
	@RequestMapping("/editUserPage")
	public String editUserPage(@RequestParam int userId, ModelMap modelMap) {
		User user = accountService.getUserById(userId);
		modelMap.addAttribute("user", user);
		return "account/userEdit";
	}
	
}
