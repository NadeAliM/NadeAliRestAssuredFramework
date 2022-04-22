package RequestChaining;

import org.testng.annotations.Test;

import CommonLibrary.JavaLibrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class createAndDeleteTest {
@Test
public void requestchaining() {
	JavaLibrary jlib=new JavaLibrary();
	ProjectLibrary plib=new ProjectLibrary("javeed", "kptcl"+jlib.getRandomNumber(), "ongoing", 4);
	baseURI ="http://localhost";
	port=8084;
	
	Response resp = given()
	.body(plib)
	.contentType(ContentType.JSON)
	
	.when()
	.post("/addProject");
	
	//step2: capture the id
	
	String proid = resp.jsonPath().get("projectId");
	System.out.println(proid);
	resp.then().log().all();
	
	
	//delete the project
	given()
	.pathParam("pid", proid)
	.when()
	.delete("/projects/{pid}")
	.then()
	.assertThat().statusCode(204)
	.log().all();
	
	
}
}
