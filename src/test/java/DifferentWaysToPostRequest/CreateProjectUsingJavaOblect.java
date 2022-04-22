package DifferentWaysToPostRequest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import CommonLibrary.JavaLibrary;
import io.restassured.http.ContentType;

public class CreateProjectUsingJavaOblect {
@Test
public void CreateProjectUsingJavaOblect() {
	JavaLibrary Jlib=new JavaLibrary();
	//STEP 1: Create The Prerequists-request body
			JSONObject JObj=new JSONObject();
			JObj.put("createdBy", "Rafeek");
			JObj.put("projectName", "All States "+Jlib.getRandomNumber());
			JObj.put("status", "Completed ");
			JObj.put("teamSize", 18);
			
			String baseuri = "http://localhost/";
			port=8084;
			
			
			given()
			.body(JObj)
			.contentType(ContentType.JSON)
			
			.when()
			.post("addProject")
			
			.then()
			.assertThat()
			.contentType(ContentType.JSON)
			.statusCode(201)
			.log().all();
}
}
