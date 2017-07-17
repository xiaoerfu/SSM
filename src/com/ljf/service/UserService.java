package com.ljf.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ljf.dao.UserDao;
import com.ljf.entity.User;

@Service("userService")
public class UserService implements UserServiceImpl {

	@Resource
	private UserDao userDao;
	
	@Override
	public User login(User user) {
		
		return userDao.login(user);
	}

	@Override
	public List<User> findUsers(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.findUsers(map);
	}

	@Override
	public Long getTotalUser(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.getTotalUser(map);
	}

	@Override
	public int updateUser(User user) {
		// 防止更改管理员的账号名
		if("admin".equals(user.getUserName())){
			return 0;
		}
		return userDao.updateUser(user);
	}

	@Override
    public int addUser(User user) {
        if (user.getUserName() == null || user.getPassword() == null || getTotalUser(null) > 90) {
            return 0;
        }
        return userDao.addUser(user);
    }

	@Override
	public int deleteUser(Integer id) {
		// 防止误删除了管理员
		if(id == 1){
			return 0;
		}
		return userDao.deleteUser(id);
	}

}
