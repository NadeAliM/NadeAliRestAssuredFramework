package PracticeCRUDOperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
@Test
public void CreateProjectTest() {
	//STEP 1: Create The Prerequists-request body
	JSONObject JObj=new JSONObject();
	JObj.put("createdBy", "NadeAli M");
	JObj.put("projectName", "Xylem");
	JObj.put("status", "Completed ");
	JObj.put("teamSize", 12);
	RequestSpecification req = RestAssured.given();
	req.body(JObj);
	req.contentType(ContentType.JSON);
	
	
	//step2: perform the action
	Response response = req.post("http://localhost:8084/addProject");
	
	//step3: validate the response
	System.out.println(response.contentType());
	System.out.println(response.asString());
	System.out.println(response.prettyPrint());
	System.out.println(response.prettyPeek());
	
}
}
