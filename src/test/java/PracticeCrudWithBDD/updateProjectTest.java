package PracticeCrudWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class updateProjectTest {
@Test
public void updateProjectTest() {
	//STEP 1: Create The Prerequists-request body
			JSONObject JObj=new JSONObject();
			JObj.put("createdBy", "NadeAli M");
			JObj.put("projectName", "Xylem");
			JObj.put("status", "ongoing ");
			JObj.put("teamSize", 18);
			
			String baseuri = "http://localhost/";
			port=8084;
			
			given()
			.body(JObj)
			.contentType(ContentType.JSON)
			
			.when()
		.put("projects/TY_PROJ_804")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
		
}
}
