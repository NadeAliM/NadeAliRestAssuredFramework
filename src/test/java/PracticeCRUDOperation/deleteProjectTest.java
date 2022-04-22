package PracticeCRUDOperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class deleteProjectTest {
@Test
public void deleteProjectTest() {
	//Step:create a prerequists
	//step2:perform the action
	
	Response reap = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_803");
	//step3: validate the response
	System.out.println(reap.contentType());
	System.out.println(reap.asString());
	System.out.println(reap.prettyPrint());
	System.out.println(reap.prettyPeek());
}
}
