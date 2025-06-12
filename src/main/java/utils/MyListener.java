package utils;




import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyListener implements ITestListener  {
	
	
	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports extent; //Populate common info on the report
	public ExtentTest test; //Create test case entries in the report and update the status of the test methods
	
	public void onStart(ITestContext context) {
		sparkReporter = new ExtentSparkReporter("extentreport.html");
		
		//System.out.println(System.getProperty("user.dir") + "/reports/myReport.html");
		sparkReporter.config().setDocumentTitle("Automation Report"); //Title of report
		sparkReporter.config().setReportName("Functional Test Report"); //name of report
		sparkReporter.config().setTheme(Theme.DARK); //set the theme for the report
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("QA Engineer", "Shree");
	}
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test passed:" + result.getName());
		
	}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed:" + result.getName());
		test.log(Status.FAIL, "Test failed because:" + result.getThrowable());
		
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Skipped:" + result.getName());
		
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
	
}
