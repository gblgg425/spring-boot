package com.grapro.bms.modules.account.controller;

import java.io.File;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.grapro.bms.modules.account.entity.User;
import com.grapro.bms.modules.account.service.AccountService;
import com.grapro.bms.modules.common.vo.Result;
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
	
	/**
	 * 编辑user
	 */
	@PostMapping(value="/editUser",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result editUser(@ModelAttribute User user) {
		return accountService.inserOrUpdatetUser(user);
	}
	
	/**
	 * 删除user
	 */
	@PostMapping(value= "/deleteUser",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	//@RequiresPermissions("deleteUser")
	public Result deleteUser(@ModelAttribute User user) {
		return accountService.deleteUserById(user.getUserId());
	}
	
	/**
	 * 跳转user 页面
	 */
	@RequestMapping("/addUserPage")
	public String addUserPage(ModelMap modelMap) {
		return "account/userAdd";
	}
	/**
	 * 添加user
	 */
	@PostMapping(value="/addUser",consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public Result addUser(@ModelAttribute User user) {
		return accountService.inserOrUpdatetUser(user);
	}
	
	
	
	/**
	 * 上传文件
	 */
	@PostMapping(value="/upload",consumes="multipart/form-data")
	@ResponseBody
	public Result uploadFile(@RequestParam MultipartFile file) {
		if (file.isEmpty()) {
			return new Result(500, "file is null.");
		}
		
		String destPath = "D:/upload/" + file.getOriginalFilename();
		try {
			File destFile = new File(destPath);
			file.transferTo(destFile);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "Upload file fail.");
		}
		
		return new Result(200, "Upload file success.", "/upload/" + file.getOriginalFilename());
	}
}
