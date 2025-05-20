package practice;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
@Test(retryAnalyzer=genericutility.RetryAnalyzerImplementation.class)

public class AssertionPractise {
	public void sampleHard() {
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		assertEquals(1,0);
		System.out.println("step 4");
		System.out.println("step 5");
		System.out.println("step 6");
	}
	@Test
	public void sampleSoft() {
		SoftAssert sa=new SoftAssert();
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
			sa.assertEquals(1,0);
			System.out.println("step 4");
			System.out.println("step 5");
			System.out.println("step 6");
			sa.assertAll();
		}
		
	



	}


