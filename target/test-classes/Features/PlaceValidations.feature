
Feature: validating place API 

#tags

@AddPlace
Scenario Outline: Verify if place is being sucessfully added using AddPlaceApi

        Given Add place payload with "<name>" "<language>" "<address>"
        When user calls "AddPlaceApi" with "post" http method
        Then the API cell is sucess with status code 200 
        And "status" in respone body is "ok"
        And "scope" in respone body is "App"
        And verify place_id created maps to "<name>" using "getPlaceApi"
        
        Examples:
        |name  | language  |address            |
        |AAhouse | Ehglish | Near pune building|
        |BBHouse | MARATHI | mUMBAI            |
        
 
@deletePlace       
 Scenario: verify if delete place functionality is working
 
       Given DeletePlace payload
       When user calls "deletePlaceAPI" with "post" http request
       Then API call got sucess with ststus code 200
       