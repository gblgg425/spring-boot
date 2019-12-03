package com.grapro.bms.modules.authority.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grapro.bms.modules.authority.service.AuthorityService;


/**
 * 授权控制器
 *
 */
//@Controller
//@RequestMapping("/authority")
public class AuthorityController {
	
	@Autowired
	private AuthorityService authorityService;
	
	/**
	 * 跳转到角色列表
	 */
	/*@RequestMapping("/roleListPage")
	public String roleListPage() {
		return "authority/roleList";
	}*/

}
