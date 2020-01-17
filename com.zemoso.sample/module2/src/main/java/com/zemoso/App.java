package com.zemoso;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class App 
{
    String result = "";
	InputStream inputStream;

    public static void main( String[] args )
    {
        System.out.println( "Executing module2" );   
        App app = new App();
        System.out.println(app.getPropValues()); 
    }

    public Map<String,String> getPropValues()  {
 
        Map<String, String> values = new HashMap<>();
		try {
			Properties prop = new Properties();
			String propFileName = "application.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			values.put("env",prop.getProperty("env"));
			values.put("ip",prop.getProperty("ip"));
			values.put("user",prop.getProperty("user"));
			
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
		finally {
			if(inputStream!=null){
				try{
					inputStream.close();
				}
				catch(IOException e){
					System.out.println("Exception: " + e);
				}
			} else {
				System.out.println("NUll");
			}
		}
		return values;
	}
}
