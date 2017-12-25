package com.zoulan.service;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.zoulan.entity.File;

public class Test {
	public static void main(String args[]){
		try {
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream("C:/Users/zoulan/Desktop/zoulan.jpg"));
	        byte[] buffer = new byte[bis.available()];;
	        try {
				bis.read(buffer);
				File file=new File();
				file.setFname("zoulan.jpg");
				file.setFcontent(buffer);
				FileServices fileService=new FileServices();
				fileService.addFile(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
