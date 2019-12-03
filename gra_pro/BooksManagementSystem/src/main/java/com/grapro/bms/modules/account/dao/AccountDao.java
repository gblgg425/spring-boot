package com.grapro.bms.modules.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
	@Insert("insert user(account, password, user_name, user_sex, "
			+ "user_telephone, user_email, user_address, user_birthday, "
			+ "user_diploma, user_entrytime,user_status) "
			+ "values(#{account}, #{password}, #{userName}, #{userSex}, "
			+ "#{userTelephone}, #{userEmail}, #{userAddress}, #{userBirthday}, "
			+ "#{userDiploma}, #{userEntrytime}, #{userStatus})")
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

	@Select("select * from user where user_status=1")
	//@ResultMap(value="userResult")
	List<User> getUserList(SearchVo userSearch);
	
	/**
	 * 根据user Id 查询user
	 */
	@Select("select * from user where user_id=#{userId}")
	User getUserById(int userId);
	
	/**
	 * 更新user
	 */
	@Update("<script> "
			+ "update user set "
			+ "<if test='password!=null'> password = #{password},</if>"
			+ "user_name=#{userName},"
			+ "user_sex=#{userSex},"
			+ "user_telephone=#{userTelephone},"
			+ "user_email=#{userEmail},"
			+ "user_address=#{userAddress},"
			+ "user_birthday=#{userBirthday},"
			+ "user_entrytime=#{userEntrytime},"
			+ "user_diploma=#{userDiploma} "
			+ "where user_id=#{userId}"
			+ "</script>"
			)
	void updateUserById(User user);
	
	
	/**
	 * 根据user id删除user
	 */
	/*
	 * 直接删除，一般不建议采用
	 @Delete("delete from user where user_id = #{userId}")
	void deleteUserById(int userId);*/
	@Update("update user set user_status=0 where user_id=#{userId}")
	void deleteUserById(int userId);

}
