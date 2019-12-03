package com.grapro.bms.modules.account.service;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.grapro.bms.modules.account.entity.User;
import com.grapro.bms.modules.common.vo.Result;
import com.grapro.bms.modules.common.vo.SearchVo;

public interface AccountService {
	
	Result inserOrUpdatetUser(User user);
	
	Result getUserResult(User user);

	User getUserByName(String account);
	
	User getUserBySubject();
	
	PageInfo<User> getUserList(SearchVo userSearch);
	
	User getUserById(int userId);
	
	Result deleteUserById(int userId);


}
