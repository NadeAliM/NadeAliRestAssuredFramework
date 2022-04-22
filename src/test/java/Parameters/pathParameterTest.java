package Parameters;

import org.testng.annotations.Test;

import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class pathParameterTest {
@Test
public void pathPatameter() {
	baseURI ="http://localhost";
	port= 8084;
	
	given()
	.pathParam("pid", "TY_PROJ_1003")
	
	.when()
	.get("/projects/{pid}")
     
	.then()
	.log().all();
}
	
	
}
