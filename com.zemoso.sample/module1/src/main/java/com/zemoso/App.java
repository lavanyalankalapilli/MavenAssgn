package com.zemoso;

import java.util.Enumeration;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;

public class App {

	final static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		System.out.println("Module1 execution begins");
	}

	public void log(){
		logger.debug("This is debug log");
		logger.info("This is info log");
		logger.warn("This is warn log");
		logger.error("This is error log");
		logger.fatal("This is fatal log");
	}
}
