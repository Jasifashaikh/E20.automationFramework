package practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractise {
       
	//@Test( enabled=false )
      // public void CreateSample() {
    	//   System.out.println("create");
      // }
      // @Test()
      // public void ModifySample() {
    	 //  Assert.fail();
    	  // System.out.println("modify");
     //  }
     //  @Test(dependsOnMethods="ModifySample")
      // public void DeleteSample() {
    	//   System.out.println("delete");
       //}
	@Test(dataProvider="getData")
	 public void CreateSample(String name,int id) {
	  System.out.println("Name is - " +name+ " and id is - " +id);
   }
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[3][2];
		data[0][0]="jasifa";
	    data[0][1]=12;
	    data[1][0]="haniya";
		data[1][1]=13;
		data[2][0]="arushi";
		data[2][1]=14;
		return data;
	}
	 


}
