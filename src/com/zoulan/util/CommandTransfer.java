package com.zoulan.util;

import java.io.Serializable;

public class CommandTransfer implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	private Object data;//��������
	private String result;//���ؽ��
	private boolean flag;//�����Ƿ�ɹ�
	private String cmd;//����ָ��
	
	public CommandTransfer(){
		super();
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	
	
	

}
