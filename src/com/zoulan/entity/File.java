package com.zoulan.entity;

import java.io.Serializable;

public class File implements Serializable{

	
	private static final long serialVersionUID=1L;
	/**
	 * @param args
	 */
	private long fid;
	private String fname;
	private byte[] fcontent;
	
	public File(){
		super();
	}
	
	public File(long id,String fname,byte[] fcontent){
		super();
		this.fid=id;
		this.fname=fname;
		this.fcontent=fcontent;
		
	}

	public long getFid() {
		return fid;
	}

	public void setFid(long fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public byte[] getFcontent() {
		return fcontent;
	}

	public void setFcontent(byte[] fcontent) {
		this.fcontent = fcontent;
	}
	

}
