package com.mmle.utils;

import java.util.Random;

import org.apache.shiro.crypto.hash.Md5Hash;

public class SaltUtils {
public static final int hashIterations = 1;
	
	//产生随机的salt
	public static String getRandomSalt(){
		Random random = new Random(); 
		//生成随机数salt的长度必须大于6
		int length = random.nextInt(50);
		System.out.println("salt确认前的长度："+length);
		while(length<=6){
			length = random.nextInt(50);
		}
		System.out.println("salt确认后的长度："+length);
	    String salt = "";  
	    //生成随机的salt
	    for (int i = 0; i < length; i++) {  
	        boolean b = random.nextBoolean();  
	        if (b) { // 字符串  
	             int choice = random.nextBoolean() ? 65 : 97; //取得65大写字母还是97小写字母  
	             salt += (char) (choice + random.nextInt(26));
	        } else { // 数字  
	        	salt += String.valueOf(random.nextInt(10));  
	        }  
	    }  
	    System.out.println("salt:"+salt);
		return salt;
	}
	public static String getMd5Password(String password,String salt){
		//产生MD5排列后的值
	    Md5Hash md5Hash = new Md5Hash(password, salt, hashIterations);
		String password_md5 =  md5Hash.toString(); 
		//System.out.println("生MD5排列后的值(长度固定为32位):"+password_md5);
		return password_md5;
	}
	

}
