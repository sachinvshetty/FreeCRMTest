package com.mascamo.qa.Util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

@Test
public class LoggerTest {

	static String configurationfilename = "C:\\Users\\s.nagaraja.setty\\Desktop\\Maven Actitime\\kormangalabranch\\log4j.properties";

	public static final Logger log = Logger.getLogger(LoggerTest.class.getName());

	public static void getlogger() {
		PropertyConfigurator.configure(configurationfilename);
	}

}
