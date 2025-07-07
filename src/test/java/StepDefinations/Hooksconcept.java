package StepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooksconcept {

	
	@Before("@deletePlace")
	public void beforescenario() throws IOException
	{
		stepdefination step=new stepdefination();
		if(stepdefination.placeid==null)
		{
		
		step.add_place_payload_with("shetty","french","asia");
		step.user_calls_with_http_method("AddPlaceApi", "POST");
		step.verify_place_id_created_maps_to_using("shetty", "getPlaceApi");
		}
	}
	
	
}
