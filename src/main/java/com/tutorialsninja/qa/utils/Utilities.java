package com.tutorialsninja.qa.utils;

import java.util.Date;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	
	public static final int PAGE_LOAD_TIME=5;
	
	public static String generatewithemailstamp() {
		Date time=new Date();
		String timeStamp=time.toString().replace(" ", "_").replace(":", "_");
		return "sashi"+timeStamp+"@gmail.com";
	}

}
