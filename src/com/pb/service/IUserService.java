package com.pb.service;

import java.util.List;

import com.pb.entity.User;

public interface IUserService {
	//增
	public boolean addUser(User user);
	//删
	public boolean delUser(int id);
	//改
	public boolean updUser(User user);
	//查
	public List<User> getAllUsers();
}
