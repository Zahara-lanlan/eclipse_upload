package com.zoulan.entity;

import java.io.Serializable;

public class User implements Serializable{
	
 private static final long serialVersionUID=1L;
	/**
	 * @param args
	 * 
	 * 背景：通过使用JDBC+IO+Socket技术编写一个控制台版的"文件上传器"，实现文件上传功能。
	 * 主要分为三个功能模块：1.用户注册   2.用户登录  3.上传文件
	 */
	private int id;
	private String userName;
	private String userPwd;
	
	public User(){
		
	}
	
	public User(int id,String username,String userPwd){
		super();
		this.id=id;
		this.userName=username;
		this.userPwd=userPwd;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	
	

}
