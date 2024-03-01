package stepdefinationfile;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class hooks {
	public static WebDriver driver;
	public static Properties p;
	public static Logger logger;
	
	@BeforeAll
	public static void setup() throws IOException 
	{
		
		//loading properties file
		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);

		//loading log4j 
		logger=LogManager.getLogger();//Log4j

//		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
//		 	{	
//			DesiredCapabilities capabilities=new DesiredCapabilities();
//			//os
//			if(os.equalsIgnoreCase("windows"))
//			{
//				capabilities.setPlatform(Platform.WIN11);
//			}
//			else if(os.equalsIgnoreCase("mac"))
//			{
//				capabilities.setPlatform(Platform.MAC);
//			}
//			else
//			{
//				System.out.println("No matching os..");
//				return;
//			}
//			//browser
//			switch(br.toLowerCase())
//			{
//			case "chrome" : capabilities.setBrowserName("chrome"); break;
//			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
//			default: System.out.println("No matching browser.."); return;
//			}
//			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//		    }
//		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
//		{
//			//launching browser based on condition - locally
//			switch(br.toLowerCase())
//			{
		
		
		  
		    
		    
//			case "chrome": 
//				driver=new ChromeDriver();
//				break;
//			case "edge": driver=new EdgeDriver(); break;
//			default: System.out.println("No matching browser..");
//						return;
//			}
//		}
        driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterAll
	public static void tearDown()
	{
		driver.quit();
	}


}


