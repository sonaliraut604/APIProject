package Resouces;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException
	{
		if(req==null)
		{
		PrintStream log=new PrintStream(new File("logging.txt"));
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		     req=new RequestSpecBuilder().setBaseUri(getglobalprop("baseURI")).addQueryParam("key", "qaclick123")
		    		 .addFilter(RequestLoggingFilter.logRequestTo(log))
		    		 .addFilter(ResponseLoggingFilter.logResponseTo(log))
		    		 
			.setContentType(ContentType.JSON).build();
			
	        return req;
}
		return req;
		
	}
	
	
	public static String getglobalprop(String key) throws IOException
	{
		FileInputStream file=new FileInputStream(System.getProperty("C:/Framework/APIFrameWork/src/test/java/Resouces/Global.properties"));
		Properties pro=new Properties();
		pro.load(file);
		return pro.getProperty(key);
		
	}
	
	
	public String getJsonPath(Response response,String key)
	{
		String newresponse=response.asString();
		JsonPath js=new JsonPath(newresponse);
		
		return js.get(key).toString();
	}
}
