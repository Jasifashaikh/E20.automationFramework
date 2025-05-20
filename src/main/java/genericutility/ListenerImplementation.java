package genericutility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
/*
 * This class provides ITestListeners Interface of TestNG 
 */

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerImplementation implements ITestListener{
      ExtentReports report;
      ExtentTest test;


	

	

	@Override
	public void onTestStart(ITestResult result) {
		//capture method name
	
		String methodName = result.getMethod().getMethodName();
		System.out.println(" # "+ methodName +  "-->test script execution started ");	
		//Capture test in extent report
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(" # "+ methodName +  "--> test script pass ");
		//log the status on Pass in extent report
		test.log(Status.PASS,methodName+"--> Test script pass");
		}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(" # "+ methodName +  "-->test script fail ");	
		//capture the exception
		System.out.println(result.getThrowable());
		// Log the status as FAIL in extent reports
				test.log(Status.FAIL, methodName + "-> Test Script FAIL");

				// Log the exception in extent report
				test.log(Status.WARNING, result.getThrowable());
		//capture screenshot
		JavaUtility j = new JavaUtility();
		SeleniumUtility s = new SeleniumUtility();
		//configure screenshot name
		String screenshotName = methodName+"-"+j.getSystemDateInFormat();
try {
			
			String path = s.CaptureScreenShot(BaseClass.sdriver, screenshotName);
			
			//attach the screenshot to extent report
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(" # "+ methodName +  " test script skip ");		
		//capture the exception
		System.out.println(result.getThrowable());
		// Log the status as SKIP in extent reports
				test.log(Status.SKIP, methodName + "-> Test Script SKIP");

				// Log the exception in extent report
				test.log(Status.WARNING, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println( " suite execution started ");
		//Basic configuration of extent report
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReport\\Report -"+new JavaUtility().getSystemDateInFormat()+".html");
		esr.config().setDocumentTitle("swag labs execution report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("automation framework execution");
		//Report generation
	    report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("base browser","microsoft edge");
		report.setSystemInfo("base platform","windows ");
		report.setSystemInfo(" base env"," Testing");
		report.setSystemInfo(" reporter name","jasifa ");
		
	}

	@Override
	public void onFinish(ITestContext context) {
	
		System.out.println(  " suite execution finished ");	
		// Report Generaation Extent Report
				report.flush();
	
	}

}
