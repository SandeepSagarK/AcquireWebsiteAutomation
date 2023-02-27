package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "Configs//Configuration.properties";

	
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
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getNewsRoomUrl() {
		String newsroomurl = properties.getProperty("newsroomurl");
		if(newsroomurl != null) return newsroomurl;
		else throw new RuntimeException("newsroomurl not specified in the Configuration.properties file.");
	}
	
	
	public String getNewsroom() {
		String newsRoom = properties.getProperty("newsRoom");
		if(newsRoom != null) return newsRoom;
		else throw new RuntimeException("newsRoom not specified in the Configuration.properties file.");
	}
	
	public String getEventsBookings() {
		String eventsBookings = properties.getProperty("eventsBookings");
		if(eventsBookings != null) return eventsBookings;
		else throw new RuntimeException("eventsBookings not specified in the Configuration.properties file.");
	}
	
	public String getRequestSupport() {
		String requestSupport = properties.getProperty("requestSupport");
		if(requestSupport != null) return requestSupport;
		else throw new RuntimeException("requestSupport not specified in the Configuration.properties file.");
	}
	
}