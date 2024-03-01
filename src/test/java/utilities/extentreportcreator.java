package utilities;

	import java.awt.Desktop;
	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.List;
	 
	 
	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;
	 
	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

import testbase.baseclass;
	 
	//import .BaseClass;
	 
	public class extentreportcreator implements ITestListener {
		public ExtentSparkReporter sparkReporter;
		public ExtentReports extent;
		public ExtentTest test;
	 
		String repName;
	 
		public void onStart(ITestContext testContext) {
			/*SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			Date dt=new Date();
			String currentdatetimestamp=df.format(dt);
			*/
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
			repName = "Test-Report-" + timeStamp + ".html";
			sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);// specify location of the report
	 
			sparkReporter.config().setDocumentTitle("ZIG WHEELS AUTOMATION REPORT"); // Title of report
			sparkReporter.config().setReportName("ZIG WHEELS FUNCTIONAL TESTING"); // name of the report
			sparkReporter.config().setTheme(Theme.DARK);
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Application", "ZIG WHEELS");
			extent.setSystemInfo("Module", "urbaladder");
			extent.setSystemInfo("Sub Module", "hackathon");
			extent.setSystemInfo("User Name", "Surya");
			extent.setSystemInfo("Environemnt", "QA");
			String os = testContext.getCurrentXmlTest().getParameter("os");
			extent.setSystemInfo("Operating System", os);
			String browser = testContext.getCurrentXmlTest().getParameter("browser");
			extent.setSystemInfo("Browser", browser);
			List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
			if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
			}
		}
	 
		public void onTestSuccess(ITestResult result) {
			test = extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups()); // to display groups in report
			test.log(Status.PASS,result.getName()+" got successfully executed");
			try {
				String imgPath = new baseclass().captureScreen(result.getName());
				test.addScreenCaptureFromPath(imgPath);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	 
		public void onTestFailure(ITestResult result) {
			test = extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.FAIL,result.getName()+" got failed");
			test.log(Status.INFO, result.getThrowable().getMessage());
		}
	 
		public void onTestSkipped(ITestResult result) {
			test = extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.SKIP, result.getName()+" got skipped");
			test.log(Status.INFO, result.getThrowable().getMessage());
		}
	 
		public void onFinish(ITestContext testContext) {
			extent.flush();
			//To open report on desktop..
			String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
			File extentReport = new File(pathOfExtentReport);
			try {
				Desktop.getDesktop().browse(extentReport.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			}
	 
		}
	}

