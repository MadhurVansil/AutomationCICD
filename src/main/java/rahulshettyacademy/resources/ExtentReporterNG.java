package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	
	// ExtentSparkReporter //ExtentReports
	
	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir") + "//report//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation test results");
		reporter.config().setDocumentTitle("Test Results");
	
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Madhur Vansil");
		return extent;
		
		
		
		
		
	}
}
