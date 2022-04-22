package PracticeCrudWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteProjectTest {
@Test

public void DeleteProjectTest() {
	String baseuri = "http://localhost/";
	port=8084;
	
	when()
	.delete("projects/TY_PROJ_804")
	
	.then()
	.assertThat()
	.contentType(ContentType.JSON)
	.statusCode(204)
	.log().all();
	
	
}
}
