package DataDriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataProvider1 {
@Test(dataProvider = "getData")
public void dataprovider(String createdBy,String projectName,String status,int teamSize) {
	ProjectLibrary plib=new ProjectLibrary(createdBy, projectName, status, teamSize);
  baseURI="http://localhost";
  port=8084;
	given()
	.body(plib)
	.contentType(ContentType.JSON)
	
	.when()
	.post("/addProject")
	
	.then()
	.log().all();
	
	
	
}

@DataProvider(name="getData")
public Object[][] data() {
	Object[][] data=new Object[3][4];
	
	data[0][0]="rafeek";
	data[0][1]="hp";
	data[0][2]="ongoing";
	data[0][3]=12;
	
	data[1][0]="harender";
	data[1][1]="google";
	data[1][2]="created";
	data[1][3]=15;
	
	data[2][0]="pandey";
	data[2][1]="paisawala";
	data[2][2]="ongoing";
	data[2][3]=18;
	
	return data;
	
	
	
	
}

}
