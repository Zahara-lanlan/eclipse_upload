package com.zoulan.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zoulan.entity.File;
import com.zoulan.util.JdbcUtils;

public class FileServices {
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	
	public boolean addFile(File file){
		   boolean flag=false;
		try {
			con=JdbcUtils.getConnetction();
			ps=(PreparedStatement) con.prepareStatement("insert into tb_file"+"values(?,?)");
			ps.setString(1, file.getFname());
			ps.setBytes(2, file.getFcontent());
			if(ps.executeUpdate()!=0){
				flag=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	

}
