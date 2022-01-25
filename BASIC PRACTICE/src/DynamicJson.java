import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DynamicJson {
	
	@Test(dataProvider="booksData")
	public void addBook(String isbn,String aisle) {
		
		RestAssured.baseURI= "http://216.10.245.166";
		
		String response=given().log().all().header("Content-Type","application/json").
		body(payload.addBook(isbn,aisle)).
		when().post("/Library/Addbook.php").
		then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		String id=js.getString("ID");
		
		System.out.println(id);
	}
	
	
	@DataProvider(name="booksData")
	public Object[][] getData(){
		return new Object[][] {{"bsc","567"},{"yuo","897"},{"opl","325"}};
	}

}
