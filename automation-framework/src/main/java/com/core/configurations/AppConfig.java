package com.core.configurations;

import java.io.File;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;


public class AppConfig {
	
	private static Config configuration;

	/**
	 * Read app configuration from conf file using given path and set properties for
	 * running test suite 
	 */
	public static void ReadAppConfig(String filePath) {

		Config defaultConfiguration = ConfigFactory.parseFile(new File(AppConfig.class.getClassLoader().getResource(filePath).getFile()));
		 configuration = ConfigFactory.parseResources(filePath).withFallback(defaultConfiguration).resolve();
		 System.out.println("Add Dummy Line for Jenkins Job");
		 }
	
	public static Config getConfiguration() {
		return configuration;
	}


}
