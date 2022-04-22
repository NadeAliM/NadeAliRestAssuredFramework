package Aunthetication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.*;

public class basicAuth {
@Test

public void basicAuth() {
	
	baseURI="http://localhost";
	port=8084;
	given()
	.auth().basic("rmgyantra", "rmgy@9999")
	
	.when()
	.get("/login")
	
	.then()
	.log().all();
}
@Test
public void basicauth() {
	baseURI="http://localhost";
	port=8084;
	given()
	.auth().preemptive().basic("rmgyantra", "rmgy@9999")
	
	.when()
	.get("/login")
	
	.then()
	.assertThat().statusCode(202)
	.log().all();

}

@Test
public void basisauth() {
	baseURI="http://localhost";
	port=8084;
	given()
	.auth().digest("rmgyantra", "rmgy@9999")
	
	.when()
	.get("/login")
	
	.then()
	.assertThat().statusCode(202)
	.log().all();
}
}
