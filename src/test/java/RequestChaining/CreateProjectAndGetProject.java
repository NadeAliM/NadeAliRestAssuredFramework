package RequestChaining;

import org.testng.annotations.Test;

import CommonLibrary.JavaLibrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectAndGetProject {
@Test
public void requestchaining() {
	JavaLibrary jlib=new JavaLibrary();
	ProjectLibrary plib=new ProjectLibrary("swati", "accenture"+jlib.getRandomNumber(), "ongoing", 10);
    
	baseURI ="http://localhost";
	port=8084;
	
	Response resp = given()
	.body(plib)
	.contentType(ContentType.JSON)
	.when()
	.post("/addProject");
	//capture the id
	
	String proid = resp.jsonPath().get("projectId");
	System.out.println(proid);
	resp.then().log().all();
	
	
	//create a get request
	
	given()
	.pathParam("pid", proid)
	.when()
	.get("/projects/{pid}")
	.then()
	.assertThat().statusCode(200)
	.log().all();
	
	
	
	
	
	
	
}
}
