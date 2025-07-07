package GraphQl;

import static io.restassured.RestAssured.*;

import org.junit.Assert;

import io.restassured.path.json.JsonPath;

public class QueryClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String response=given().log().all().header("Content-Type","application/json")
		.body("\\n          \\n          locations\\n          args {\\n            ...InputValue\\n          }\\n        }\\n      }\\n    }\\n\\n    fragment FullType on __Type {\\n      kind\\n      name\\n      description\\n      fields(includeDeprecated: true) {\\n        name\\n        description\\n        args {\\n          ...InputValue\\n        }\\n        type {\\n          ...TypeRef\\n        }\\n        isDeprecated\\n        deprecationReason\\n      }\\n      inputFields {\\n        ...InputValue\\n      }\\n      interfaces {\\n        ...TypeRef\\n      }\\n      enumValues(includeDeprecated: true) {\\n        name\\n        description\\n        isDeprecated\\n        deprecationReason\\n      }\\n      possibleTypes {\\n        ...TypeRef\\n      }\\n    }\\n\\n    fragment InputValue on __InputValue {\\n      name\\n      description\\n      type { ...TypeRef }\\n      defaultValue\\n    }\\n\\n    fragment TypeRef on __Type {\\n      kind\\n      name\\n      ofType {\\n        kind\\n        name\\n        ofType {\\n          kind\\n          name\\n          ofType {\\n            kind\\n            name\\n            ofType {\\n              kind\\n              name\\n              ofType {\\n                kind\\n                name\\n                ofType {\\n                  kind\\n                  name\\n                  ofType {\\n                    kind\\n                    name\\n                  }\\n                }\\n              }\\n            }\\n          }\\n        }\\n      }\\n    }\\n  \",\"operationName\":\"IntrospectionQuery\"}")
		.when().post("https://rahulshettyacademy.com/gq/graphql")
		.then().log().all().extract().response().asString();
		
		System.out.println(response);
        
		JsonPath path=new JsonPath(response);
		String character=path.getString("data.charcter.name");
		Assert.assertEquals(character, "robin");
		
		JsonPath path1=new JsonPath(response);
		String character1=path.getString("data.charcter.name");
		Assert.assertEquals(character, "robin");
		
	}

}
