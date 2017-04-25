package com.pb.service.impl;

import java.util.List;

import com.pb.dao.IUserDao;
import com.pb.entity.User;
import com.pb.service.IUserService;

public class UserServiceImpl implements IUserService{
	private IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

}
