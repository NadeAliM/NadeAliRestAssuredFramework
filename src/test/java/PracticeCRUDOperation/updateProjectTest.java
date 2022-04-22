package PracticeCRUDOperation;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class updateProjectTest {
@Test

	public void updateProjectTest() {
	//STEP 1: Create The Prerequists-request body
	JSONObject JObj=new JSONObject();
	JObj.put("createdBy", "NadeAli M");
	JObj.put("projectName", "Xylem");
	JObj.put("status", "Completed ");
	JObj.put("teamSize", 15);
	
	RequestSpecification req = RestAssured.given();
	req.body(JObj);
	req.contentType(ContentType.JSON);
	
	
	//step2: perform the action
	Response resp = req.put("http://localhost:8084/projects/TY_PROJ_803");
	
	
	//step3:validation
	int actststus = resp.getStatusCode();
	Assert.assertEquals(actststus, 200);
	resp.then().log().all();
	}
}
