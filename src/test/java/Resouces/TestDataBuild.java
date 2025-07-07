package Resouces;

import java.util.ArrayList;

import Pojo.AddPlace;
import Pojo.Location;

public class TestDataBuild {

	public AddPlace AddPlacePayload(String name, String language, String address)
	{
		
		AddPlace ad=new AddPlace();
		ad.setAccuracy(50);
		ad.setName(name);
		ad.setPhone_number("(+91) 983 893 3937");
		ad.setAddress(address);
		ad.setWebsite("https://rahulshettyacademy.com");
		ad.setLanguage(language);
		
		ArrayList<String>mylist=new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		
		ad.setTypes(mylist);
		
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ad.setLocation(l);
		return ad;
		
		
	}
	
	public String deletePlaceApi(String placeid)
	{
		return "{\r\n    \"place_id\": \""+placeid+"\"\r\n}";
	}
}
