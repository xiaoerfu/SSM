package com.ljf.dao;

import java.util.List;
import java.util.Map;

import com.ljf.entity.User;

public interface UserDao {

	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	/**
	 * 查询用户
	 * @param map
	 * @return
	 */
	public List<User> findUsers(Map<String, Object>map);
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	public Long getTotalUser(Map<String, Object>map);
	
	/**
	 * 修改用户
	 */
	/**
	 * 
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	
	/**
	 * 添加用户
	 */
	/**
	 * 
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	
	/**
	 * 删除用户
	 */
	/**
	 * 
	 * @param id
	 * @return
	 */
	public int deleteUser(Integer id);
}
