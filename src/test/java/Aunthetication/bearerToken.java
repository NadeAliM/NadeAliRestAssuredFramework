package Aunthetication;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class bearerToken {
@Test
public void bearerToken() {
	JSONObject jobj=new JSONObject();
	
	baseURI ="https://api.github.com";
	jobj.put("name", "sdet30-restAssured");
	
	given()
	.auth()
	.oauth2("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")
	.body(jobj)
	.contentType(ContentType.JSON)
	
	.when()
	.post("/user/repos")
	.then().log().all();
}
}
