package DifferentWaysToPostRequest;

import org.testng.annotations.Test;

import CommonLibrary.JavaLibrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPoja {
@Test
public void createproject() {
	JavaLibrary jlib =new JavaLibrary();
	baseURI ="http://localhost";
	port =8084;
	
	
	ProjectLibrary plib=new ProjectLibrary("harry", "Accenture"+jlib.getRandomNumber(), "completed", 20);
	given()
	.body(plib)
	.contentType(ContentType.JSON)
	
	.when()
	.post("addProject")
	
	.then()
	.assertThat()
	.statusCode(201)
	.log().all();
	
	

	
	
	
			
}
}
