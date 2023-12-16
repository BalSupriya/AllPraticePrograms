package com.nt.service;

import java.util.Calendar;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;




public class WishMsg 
{
	public static final Logger logger=Logger.getLogger(WishMsg.class);
	
	public static void main(String[] args) {
		
		PatternLayout layout=new PatternLayout();
		String convesionPattern= "%d %t %l %m %n";
		layout.setConversionPattern(convesionPattern);
		
		ConsoleAppender conapp=new ConsoleAppender();
		conapp.setLayout(layout);
		conapp.activateOptions();
		
		//configure root logger
		Logger rootLogger=logger.getRootLogger();
		rootLogger.setLevel(Level.INFO);
		rootLogger.addAppender(conapp);
		
		logger.info("Main method start");
		
		//logger.log(Level.INFO, "Main method start");
		//System.out.println();
	
	Calendar cal=Calendar.getInstance();
	Integer hour=cal.get(Calendar.HOUR_OF_DAY);
	
	if(hour>6 && hour<12) {
	System.out.println("GOOD MORNING");
	}
	
	else if(hour>12 && hour<16) {
		System.out.println("GOOD AFTERNOON");
		}
	else if(hour>16 && hour<20) {
		System.out.println("GOOD EVENING");
		}
	else
		System.out.println("GOOD NIGHT");
		
   logger.info("Main method end");
	}
}
