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
	Socket socket=null;//�ͻ���socket
	Scanner scanner=new Scanner(System.in);
	User user=null;
	File file=null;
	
	public void showMenu(){
		System.out.println("****��ӭʹ�ÿ���̨�ļ��ϴ���****");
		System.out.println("1.��¼");
		System.out.println("2.ע��");
		System.out.println("3.�˳�");
		System.out.println("**********************");
		System.out.println("��ѡ��");
		switch(scanner.nextInt()){
		case 1:
			doLogin();
			break;
		case 2:
			doRegister();
			break;
		case 3:
			System.out.println("��������");
			break;
			
		}
		
	}

	private void doRegister()  {
		// TODO Auto-generated method stub
		user=new User();
		CommandTransfer commandTransfer=new CommandTransfer();
		while(true){
			System.out.println("�������û�����");
			user.setUserName(scanner.next());
			System.out.println("���������룺");
			user.setUserPwd(scanner.next());
			System.out.println("���ٴ��������룺");
			String rePassword=scanner.next();
			if(!rePassword.equals(user.getUserPwd())){
				System.out.println("******������������벻һ��******");
				continue;
				
			}
			commandTransfer.setCmd("register");
			commandTransfer.setData(user);
			try {
				socket=new Socket("27.0.0.1",8888);
				sendData(commandTransfer);//�������ݸ�������
				commandTransfer=getData();//�ӷ�������ȡ����
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
				 System.out.println("���Ѿ��������λ��ᣬ���´ε�¼��");
				 System.exit(0);
			 }
			 System.out.print("�������û�����");
			 user.setUserName(scanner.next());
			 System.out.print("���������룺");
			 user.setUserPwd(scanner.next());
			 commandTransfer.setData(user);
			 commandTransfer.setCmd("login");
			 try {
				Socket socket=new Socket("localhost",8888);
				sendData(commandTransfer);//�������ݸ�������
				commandTransfer=getData();//�ӷ�������ȡ����
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
  //���ܷ��������͹���������
	private CommandTransfer getData() {
		// TODO Auto-generated method stub
		InputStream is;
		ObjectInputStream osi;
		CommandTransfer commandTransfer=null;
		try {
			is=socket.getInputStream();
			//���ֽ���ת���ɶ�����
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
//���������������
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
		//�������ת���ɶ��������
		
		
	}

}
