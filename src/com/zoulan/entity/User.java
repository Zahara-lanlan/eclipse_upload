package com.zoulan.entity;

import java.io.Serializable;

public class User implements Serializable{
	
 private static final long serialVersionUID=1L;
	/**
	 * @param args
	 * 
	 * ������ͨ��ʹ��JDBC+IO+Socket������дһ������̨���"�ļ��ϴ���"��ʵ���ļ��ϴ����ܡ�
	 * ��Ҫ��Ϊ��������ģ�飺1.�û�ע��   2.�û���¼  3.�ϴ��ļ�
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
