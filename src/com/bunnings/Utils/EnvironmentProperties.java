package com.bunnings.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentProperties {

	public EnvironmentProperties()
	{

	}
	public String getCurrentEnvironmentName() throws FileNotFoundException {
		Properties propMainEnvFile = new Properties();
		
		
		InputStream inputStreamMain = new FileInputStream(System.getProperty("user.dir")+"//src//com//bunnings//Utils//env.Properties");
		try {
			propMainEnvFile.load(inputStreamMain);
		} catch(FileNotFoundException e) {
			System.out.println("Environment Properties File - env.properties Not Found");
		} catch(IOException e) {
			System.out.println("Error while Opening env.properties file");
		}

		String currentEnvironment = propMainEnvFile.getProperty("environment.to.be.used");
		propMainEnvFile.setProperty("environment.to.be.used", currentEnvironment);
		return currentEnvironment;
	}
	
	
	public String getProperty(String key) throws FileNotFoundException {
		String currentEnvironment = getCurrentEnvironmentName()+".properties";
		//currentEnvironment = currentEnvironment.toLowerCase() + ".properties";
				
		//Use the current environment property file to retrieve environment specific data
		Properties properties = new Properties();
		InputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"//src//com//bunnings//Utils//"+currentEnvironment);
		
		try {
			properties.load(inputStream);
			inputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Environment Properties File - " + currentEnvironment + " Not Found");
		} catch (IOException e) {
			System.out.println("Error while Opening " + currentEnvironment + " file");
		}
		
		String value = properties.getProperty(key);
		return value;
	}
}
