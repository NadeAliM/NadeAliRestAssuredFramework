package PracticeCRUDOperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {
@Test
public void GetSingleProject() {
	//step2: perform action
	Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_809");
	//step3: validation
	resp.contentType();
	resp.asString();
	resp.prettyPrint();
	resp.prettyPeek();
	
}
}
