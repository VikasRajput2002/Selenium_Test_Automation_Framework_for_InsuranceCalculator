package Generic;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesOperations {

	static Properties properties = new Properties();
	// for read the data/ get data using key

	public static  String getPropertyByKey(String key) throws Exception {
		//1. load data form properties file
		// file location
		// hard coded
		// String filePath = "C:\\Users\\vikash.rajput\\Desktop\\Automation\\InsuranceCalculator\\src\\test\\resource\\config.properties";
		String propFilePath = System.getProperty("user.dir") + "/src/test/resources/config.properties"; 

		// load data
		FileInputStream inputFile = new FileInputStream(propFilePath);
		properties.load(inputFile);

		//2. read data
		String value = properties.get(key).toString();
		if(StringUtils.isEmpty(value)) {
			throw new Exception("Value is not specified for key " +key);
		}


		return value;
	}

}
