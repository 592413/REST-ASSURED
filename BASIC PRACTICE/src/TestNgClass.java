import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;


public class TestNgClass {
	
	@Test
	private void testCoursePrice() {
		double totalCourseAmount = 0.0;
		JsonPath js= new JsonPath(payload.CourseDetails());
		
		int courseCount=js.getInt("courses.size()");
		double purchaseAmount=js.getDouble("dashboard.purchaseAmount");
		
		for(int i=0;i<courseCount;i++) {
			
			totalCourseAmount+=(js.getDouble("courses["+i+"].price")*js.getInt("courses["+i+"].copies"));
			
			System.out.println(totalCourseAmount);	
			
		}
		
			Assert.assertEquals(totalCourseAmount, purchaseAmount);
		
	}

}
