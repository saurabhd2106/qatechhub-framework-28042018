package test;

import java.util.Properties;

public class DemoConfigFileReadUils {
	
	public static void main(String[] args) throws Exception {
		Properties configProperty = new Properties();
		
		String filename = System.getProperty("user.dir") + "/config/config.properties";
		
		configProperty = commonLibs.utils.ReadConfigFileUtils.readProperties(filename);
		
		System.out.println(configProperty.getProperty("browserType"));
	}

}
