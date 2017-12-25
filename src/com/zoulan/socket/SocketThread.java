package com.zoulan.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketThread implements Runnable{
     private Socket socket=null;
     private ObjectInputStream ois=null;
     private ObjectOutputStream oos=null;
     
     public SocketThread(Socket socket){
    	 this.socket=socket;
     }


public void run() {
	// TODO Auto-generated method stub
	 try {
		InputStream is=socket.getInputStream();
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br=new BufferedReader(isr);
		String data=br.readLine();
		while(data!=null){
			System.out.println("¿Í»§¶ËËµ"+data);
			data=br.readLine();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 try {
		OutputStream os=socket.getOutputStream();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}}
