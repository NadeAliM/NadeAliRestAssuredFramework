package ValidateResponse;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class responseValidation {
@Test
public void responsetimeValidation() {
	baseURI ="http://localhost";
	port=8084;
	 Response resp = when()
	.get("/projects");
	
	resp.then()
	.assertThat().time(Matchers.lessThan(500l),TimeUnit.MILLISECONDS)
	
	.log().all();
	long t1 = resp.time();
	
	System.out.println("response time is "+t1);
}
}
