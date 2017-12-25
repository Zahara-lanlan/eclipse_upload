package com.zoulan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//连接数据库000
public class JdbcUtils {
 
	
	
	public static Connection getConnetction() throws Exception{
		Connection con=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=zoulan","sa","123");
			System.out.println("数据库连接成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	//释放资源
	//public static void releaseAll(ResultSet rs,PreparedStatement pst,Connection con){}
	

}
