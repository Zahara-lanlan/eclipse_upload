package com.zoulan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//�������ݿ�000
public class JdbcUtils {
 
	
	
	public static Connection getConnetction() throws Exception{
		Connection con=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=zoulan","sa","123");
			System.out.println("���ݿ����ӳɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	//�ͷ���Դ
	//public static void releaseAll(ResultSet rs,PreparedStatement pst,Connection con){}
	

}
