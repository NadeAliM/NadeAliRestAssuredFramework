package PracticeCrudWithBDD;

import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static   io.restassured.RestAssured.*;

public class GetSingleProjectTest {
@Test
public void GetSingleProject() {

	String baseuri = "http://localhost/";
	port=8084;
	
	when()
	.get("projects/TY_PROJ_804")
	
	.then()
	.assertThat()
	.contentType(ContentType.JSON)
	.statusCode(200)
	.log().all();
	
}
	
	
	
	
	
}
