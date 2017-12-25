package com.zoulan.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zoulan.entity.File;
import com.zoulan.entity.User;
import com.zoulan.util.JdbcUtils;

public class UserService {
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	boolean flag=false;
	
	public boolean addUser(User user){
		try {
			con=JdbcUtils.getConnetction();
			pst=con.prepareStatement("insert into tb_user(id,userName,userPwd"+"values(?+?+?)");
			pst.setInt(1, user.getId());
			pst.setString(2, user.getUserName());
			pst.setString(3, user.getUserPwd());
			if(pst.executeUpdate()!=0)
			{
				flag=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
		
		
	public boolean loginUser(User user){
		
		boolean flag=false;
		try {
			con=JdbcUtils.getConnetction();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			pst=(PreparedStatement) con.prepareStatement("select * from tb_user where userName=? and userPwd=?");
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getUserPwd());
			rs=pst.executeQuery();
			while(rs.next()){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}	
	

}
