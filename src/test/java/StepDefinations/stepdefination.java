package StepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

//import SerializeMethod.AddPlace;
//import SerializeMethod.Location;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.junit.Assert.*;
import Pojo.AddPlace;
import Pojo.Location;
import Resouces.EnumClass;
import Resouces.TestDataBuild;
import Resouces.Utils;

public class stepdefination extends Utils{
	
	RequestSpecification responseString;
	 ResponseSpecification responsesp;
	 Response response;
	 static String placeid;
	 
	 TestDataBuild test=new TestDataBuild();
	
	 @Given("Add place payload with {string} {string} {string}")
	 public void add_place_payload_with(String name, String language, String address) throws IOException {
		
	
	    
		responseString=given().log().all().spec(requestSpecification())
				.body(test.AddPlacePayload(name, language, address));
				
		
	}

	 @When("user calls {string} with {string} http method")
	 public void user_calls_with_http_method(String resource, String method) {
		 
		EnumClass resourceApi=EnumClass.valueOf(resource);
		System.out.println(resourceApi.getresource());
		
		responsesp=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("post"))
		{
		 response=responseString.when().post(resourceApi.getresource());
		}
		else if(method.equalsIgnoreCase("Get"))
		{
			response=responseString.when().get(resourceApi.getresource());
		}
	   
	}

	@Then("the API cell is sucess with status code {int}")
	
			public void the_api_cell_is_sucess_with_status_code(Integer int1) {
				
			assertEquals(response.getStatusCode(),200);
		
		
	}

	@Then("{string} in respone body is {string}")
	public void in_respone_body_is(String actualkey, String ExpectedKaey) {
	   
		assertEquals(getJsonPath(response,actualkey),ExpectedKaey);
				
	}
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedname, String resouce) throws IOException {
	   
		placeid=getJsonPath(response,"place_id");
		
		responseString=given().log().all().spec(requestSpecification()).queryParam("place_id", placeid);
		
		String actualName=getJsonPath(response,"name");
		
		assertEquals(actualName,expectedname);
	}
	
	
	@Given("DeletePlace payload")
	public void delete_place_payload() throws IOException {
	    
		responseString=given().spec(requestSpecification()).body(test.deletePlaceApi(placeid));
	}
	
}
