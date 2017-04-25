package com.pb.dao;

import java.util.List;

import com.pb.entity.User;

public interface IUserDao {
	//增
	public boolean addUser();
	//删
	public boolean delUser();
	//改
	public boolean updUser();
	//查
	public List<User> getAllUsers();
}
