package com.crm.GenricUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * 
	 * @return String
	 */
	public String getRandomNumber() {
		Random ran=new Random();
		int num = ran.nextInt(500);
		
		return num+"";
	}
	/**
	 * used to get random number
	 */
	
	/**
	 * 
	 * @return date in String
	 */
	public String getDate() {
		Date d=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		
		return formatter.format(d);
		
	}
	/**
	 * used to get date in yyyy-mm-dd format
	 */
	
	/**
	 * 
	 * @return date in String
	 */
	public String getDateNormalFormat() {
		Date d=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		
		return formatter.format(d);
		
	}
	/**
	 * used to get date in dd-mm-yyyy format
	 */

}
