import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class CourseTest {

	public static void main(String[] args) {
		
		JsonPath js= new JsonPath(payload.CourseDetails());
		
		double totalCourseAmount = 0.0;
		
		//1. Print No of courses returned by API
		
		int courseCount=js.getInt("courses.size()");
		System.out.println(courseCount);
		
		//2. Print purchase amount
		
		double purchaseAmount=js.getDouble("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		
		//3. Print Title of the first course
		
		String firstCourseName=js.getString("courses[0].title");
		System.out.println(firstCourseName);
		
		//4.Print All course titles and their respective Prices
		
		for(int i=0;i<courseCount;i++) {
			System.out.println(js.getString("courses["+i+"].title"));
			System.out.println(js.getDouble("courses["+i+"].price"));
		}
		
		//5. Print no of copies sold by RPA Course
		
		for(int i=0;i<courseCount;i++) {
			
			String courseTitle=js.getString("courses["+i+"].title");
			
			if(courseTitle.equalsIgnoreCase("RPA")) {
				System.out.println("The number of RPA copies :"+js.getInt("courses["+i+"].copies"));
				break;
			}
			
		}
		
		//6 Verify if Sum of all Course prices matches with Purchase Amount
		
		
		
		
		
	

}



}
