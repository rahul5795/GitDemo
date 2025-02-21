package genericutilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	
	public static ExtentReports getReportObject() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-" + timeStamp + ".html";
		String path=System.getProperty("user.dir") + "//reports//" + repName;
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
		sparkReporter.config().setDocumentTitle("Ecommerce_Framework Automation Report");// Title of report
		sparkReporter.config().setReportName("Ecommerce_Framework functional Testing");// Name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		//extent.setSystemInfo("Application URL", pro.getProperty("url"));
		//	extent.setSystemInfo("Browser Name", pro.getProperty("browser"));
			//extent.setSystemInfo("User Name", pro.getProperty("username"));
			//extent.setSystemInfo("Password", pro.getProperty("password"));
			extent.setSystemInfo("Application", "Ecommerce_Project");
			extent.setSystemInfo("Module", "Admin");
			extent.setSystemInfo("Sub Module", "Customers");
			extent.setSystemInfo("User Name", System.getProperty("user.name"));
			extent.setSystemInfo("Enviroment", "QA");
			extent.setSystemInfo("User Name", System.getProperty("os.name"));
			extent.setSystemInfo("User Name", System.getProperty("user.name"));
			extent.setSystemInfo("Java Version", System.getProperty("java.version"));
			
			return extent;
		

	}

}
