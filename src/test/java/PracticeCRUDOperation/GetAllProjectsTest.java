package PracticeCRUDOperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjectsTest {
@Test
public void GetAllProjects() {
	//step1:create a request
	//step2:perform the action
	Response resp = RestAssured.get("http://localhost/8084/projects");

	
	//step3:validation
	resp.contentType();
	resp.asString();
	resp.prettyPrint();
	resp.prettyPeek();
	
}
}
