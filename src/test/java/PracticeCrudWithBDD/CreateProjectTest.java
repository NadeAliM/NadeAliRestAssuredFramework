package PracticeCrudWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectTest {

	
	@Test
	public void CreateProjectTest() {
		
		//STEP 1: Create The Prerequists-request body
		JSONObject JObj=new JSONObject();
		JObj.put("createdBy", "NadeAli M");
		JObj.put("projectName", "Xylem");
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
