package com.zoulan.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.zoulan.entity.File;
import com.zoulan.entity.User;
import com.zoulan.util.CommandTransfer;

public class Client {

	/**
	 * @param args
	 */
	Socket socket=null;//客户端socket
	Scanner scanner=new Scanner(System.in);
	User user=null;
	File file=null;
	
	public void showMenu(){
		System.out.println("****欢迎使用控制台文件上传器****");
		System.out.println("1.登录");
		System.out.println("2.注册");
		System.out.println("3.退出");
		System.out.println("**********************");
		System.out.println("请选择：");
		switch(scanner.nextInt()){
		case 1:
			doLogin();
			break;
		case 2:
			doRegister();
			break;
		case 3:
			System.out.println("输入有误！");
			break;
			
		}
		
	}

	private void doRegister()  {
		// TODO Auto-generated method stub
		user=new User();
		CommandTransfer commandTransfer=new CommandTransfer();
		while(true){
			System.out.println("请输入用户名：");
			user.setUserName(scanner.next());
			System.out.println("请输入密码：");
			user.setUserPwd(scanner.next());
			System.out.println("请再次输入密码：");
			String rePassword=scanner.next();
			if(!rePassword.equals(user.getUserPwd())){
				System.out.println("******两次输入的密码不一致******");
				continue;
				
			}
			commandTransfer.setCmd("register");
			commandTransfer.setData(user);
			try {
				socket=new Socket("27.0.0.1",8888);
				sendData(commandTransfer);//发送数据给服务器
				commandTransfer=getData();//从服务器获取数据
				System.out.println(commandTransfer.getResult());
				System.out.println("*********************");
				if(commandTransfer.isFlag()){
					break;
				}
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		doRegister();	
		
	}

	private void doLogin() {
		// TODO Auto-generated method stub
		 user=new User();
		 CommandTransfer commandTransfer=new CommandTransfer();
		 int count=0;
		 while(true){
			 count++;
			 if(count>3){
				 System.out.println("您已经用完三次机会，请下次登录！");
				 System.exit(0);
			 }
			 System.out.print("请输入用户名：");
			 user.setUserName(scanner.next());
			 System.out.print("请输入密码：");
			 user.setUserPwd(scanner.next());
			 commandTransfer.setData(user);
			 commandTransfer.setCmd("login");
			 try {
				Socket socket=new Socket("localhost",8888);
				sendData(commandTransfer);//发送数据给服务器
				commandTransfer=getData();//从服务器获取数据
				System.out.println(commandTransfer.getResult());
				System.out.println("*********************");
				if(commandTransfer.isFlag()){
					break;
				}
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		doLogin(); 
	}
  //接受服务器发送过来的数据
	private CommandTransfer getData() {
		// TODO Auto-generated method stub
		InputStream is;
		ObjectInputStream osi;
		CommandTransfer commandTransfer=null;
		try {
			is=socket.getInputStream();
			//将字节流转换成对象流
			osi=new ObjectInputStream(is);
			try {
				commandTransfer=(CommandTransfer)osi.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commandTransfer;
	}
//向服务器发送数据
	private void sendData(CommandTransfer commandTransfer) {
		// TODO Auto-generated method stub
		try {
			OutputStream os=socket.getOutputStream();
			ObjectOutputStream oos=new ObjectOutputStream(os);
			oos.writeObject(commandTransfer);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将输出流转换成对象输出流
		
		
	}

}
