package com.pb.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.pb.entity.User;
import com.pb.service.IUserService;

public class UserAction extends BaseAction implements ModelDriven<User>{
	private User user;
	private IUserService userService;
	private String path;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getModel() {
		if(user==null){
			user  = new User();
		}
		return user;
	}
	//登录
	public String login(){
		System.out.println("昵称："+user.getUsername()+",密码："+user.getPassword());
		this.setPath("jsp/Success.jsp");
		List<User> user = userService.getAllUsers();
		System.out.println(user);
		return "ok";
	}

}
