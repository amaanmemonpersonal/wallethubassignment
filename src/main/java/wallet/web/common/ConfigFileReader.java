package wallet.web.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	protected static Properties properties;
	String workingDir = System.getProperty("user.dir");
	private final String propertyFilePath= workingDir+"/Configuration.properties";

	/**
	 * This Class use to Read Configuration file 
	 * Where we are defining complete mobile 
	 * properties
	 * */
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	/** 
	 * this method reads UAT enviroment name 
	 */
	public String getEnvName() {
		String envName = properties.getProperty("envName");
		if(envName!= null) return envName;
		else throw new RuntimeException("Enviroment is not specified in the Configuration.properties file.");	
	}
}
