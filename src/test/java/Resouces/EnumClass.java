package Resouces;

//enum is keyword in java it is used to group of name constant

public enum EnumClass {
	
	AddPlaceApi("/maps/api/place/add/json"),
	getPlaceApi("/maps/api/place/get/json"),
	deletePlaceApi("/maps/api/place/delete/json");

	
	private String resource;
	
	EnumClass(String resource)
	{
		this.resource=resource;
	}
	
	public String getresource()
	{
		return resource;
	}

}
