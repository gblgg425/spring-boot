package com.grapro.bms.modules.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.grapro.bms.modules.account.entity.User;
import com.grapro.bms.modules.common.vo.SearchVo;

/**
 * 账户相关dao
 * 
 */
@Repository
@Mapper
public interface AccountDao {
	
	/**
	 * 插入用户
	 */
	@Insert("insert into user (account,password,user_status) value (#{account}, #{password},#{userStatus})")
	// 获取插入数据的ID
	@Options(useGeneratedKeys=true,keyColumn="user_id",keyProperty="userId")
	void insertUser(User user);
	
	/**
	 * 根据用户名 查询 user
	 */
	@Select("select * from user where account=#{account}")
	@Results(id="userResult", value= {
			@Result(column="account",property="account"),
			@Result(column="password",property="password")
	})
	User getUserByName(String account);

	@Select("select * from user")
	//@ResultMap(value="userResult")
	List<User> getUserList(SearchVo userSearch);
	
	/**
	 * 根据user Id 查询user
	 */
	@Select("select * from user where user_id=#{userId}")
	User getUserById(int userId);

}
