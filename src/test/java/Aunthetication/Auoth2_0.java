package Aunthetication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auoth2_0 {
@Test
public void auth2_0() {

	
	Response resp = given()
	.formParam("client_id", "sdet30-coops")
	.formParam("client_secret", "635637bcc42437d9676e73df258f68a0")
	.formParam("grant_type", "client_credentials")
	.formParam("redirect_uri", "http://practice.com")
	.formParam("code", "authorization_code")
	
	.when()
	.post("http://coop.apps.symfonycasts.com/token");
	
	
	
	String token = resp.jsonPath().get("access_token");
	System.out.println(token);
	
	given()
	.auth().oauth2(token)
	.pathParam("USER_ID", 3103)
	
	.when()
	.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
	
	.then().log().all();
	
	
	
	
}
}
