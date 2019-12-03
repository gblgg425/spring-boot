package com.grapro.bms.modules.account.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grapro.bms.modules.account.dao.AccountDao;
import com.grapro.bms.modules.account.entity.User;
import com.grapro.bms.modules.account.service.AccountService;
import com.grapro.bms.modules.common.vo.Result;
import com.grapro.bms.modules.common.vo.SearchVo;
import com.grapro.bms.util.MD5Util;

@Service
public class AccountServiceImpl implements AccountService{

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

	
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public Result insertUser(User user) {
		
		user.setUserStatus(1);
		
		if (user == null || StringUtils.isBlank(user.getAccount()) 
				|| StringUtils.isBlank(user.getPassword()) ) {
			return new Result(500, "User name or password is null.");
		}
		
		User existUser = accountDao.getUserByName(user.getAccount());
		if (existUser != null && 
				((existUser.getUserId() != user.getUserId()) )) {
			return new Result(500, "User is exist.");
		}
		
		try {
			user.initUserPassword();
			accountDao.insertUser(user);
			return new Result(200, "insert user success.", user);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.debug(e.getMessage());
			return new Result(500,"insert user fail.");
		}
		
	}

	// 用户登录获取用户信息，添加shiro用户验证、用户授权以及记住我功能点
	@Override
	public Result getUserResult(User user) {
		Subject subject = SecurityUtils.getSubject();
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), MD5Util.getMD5(user.getPassword()));
			token.setRememberMe(user.getRememberMe());
			
			// 登录验证，调用MyRealm中doGetAuthenticationInfo方法
			subject.login(token);
			
			// 授权，调用MyRealm中doGetAuthorizationInfo方法
			subject.checkRoles();
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500,e.getMessage());
		}
		return new Result(200,"success");
	}

	/* 
	 * 从shiro中获取user
	 */
	@Override
	public User getUserBySubject() {
		Subject subject = SecurityUtils.getSubject();
		System.out.println("从shiro中获取user："+subject.getPrincipal());
		return getUserByName((String)subject.getPrincipal());
	}
	
	/* 
	 * 根据用户名查询user
	 */
	@Override
	public User getUserByName(String account) {
		return accountDao.getUserByName(account);
	}

	/* 
	 * 根据页面查询条件获取user 列表，封装到pageInfo对象中
	 */
	@Override
	public PageInfo<User> getUserList(SearchVo userSearch) {
		Subject subject = SecurityUtils.getSubject();
		String currentRole = (String) subject.getPrincipal();
		List<User> users = new ArrayList<User>();
		SearchVo.initSearchVo(userSearch);
		PageHelper.startPage(userSearch.getCurrentPage(), userSearch.getPageSize());
		if ("staff".equals(currentRole)) {
		} else {
			users = accountDao.getUserList(userSearch);
		}
		return new PageInfo<>(users);
		
	}

	@Override
	public User getUserById(int userId) {
		return accountDao.getUserById(userId);
	}

	

}
