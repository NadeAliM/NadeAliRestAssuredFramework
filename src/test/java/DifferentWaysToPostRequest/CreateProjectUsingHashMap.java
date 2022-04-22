package DifferentWaysToPostRequest;

import java.util.HashMap;

import org.testng.annotations.Test;

import CommonLibrary.JavaLibrary;
import io.restassured.http.ContentType;

import  static io.restassured.RestAssured.*;

public class CreateProjectUsingHashMap {
	@Test
public void CreateProjectUsingHashMap() {
	JavaLibrary jlib=new JavaLibrary();
	baseURI="http://localhost";
	port=8084;
	HashMap map=new HashMap();
	map.put("createdBy", "harender");
	map.put("projectName", "google "+jlib.getRandomNumber());
	map.put("status", "completed");
	map.put("teamSize", 1);
	
	given()
	.body(map)
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
