package testcase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.SecondPage;
import pageobjects.loginpage;
import pageobjects.thirdpage;
import testbase.baseclass;
import utilities.excel;

public class testcase_zigwheels01 extends baseclass{
	
   
	public Homepage fp;
	public SecondPage sp;
	public loginpage lp;
	@Test(priority = 1,groups= {"regression"})
	public void mainlog()
	{
	logger.info("****** starting testcase_zigwheels01 ******" );
	

	fp=new Homepage(driver);
	fp.gettxt();
	
	
	}
	@Test(priority = 2,groups= {"regression"})
	public void getupbikes()
	{
		fp=new Homepage(driver);
		fp.Ncars();
		logger.info("perform action on new cars");
	}
	
	@Test(priority=3 ,groups= {"regression"})
	public void Selectupbikes()
	{
		fp=new Homepage(driver);
		fp.upcomoingbikes();
		logger.info("clicked on upcoming cars");
	}
	@Test(priority = 4 ,groups= {"regression"})
	public void gethonda () throws IOException
	{
		logger.info("printing deatils of honda bikes");
		sp=new SecondPage(driver);
		sp.dropdown();
		logger.info("selcting dropsown");
	}
	@Test(priority = 5,groups= {"regression"})
	public void sdrop()
	{
		
		sp.Honda();
		logger.info("selecting honda");
	}
	@Test(priority = 6,groups= {"regression"})
	public void selectingreadmore()
		{
			sp=new SecondPage(driver);
			sp.readm();
			logger.info("selcting readmore");
		}
			
	@Test(priority = 7 ,groups= {"regression"})
		public void printingreqdetails() throws IOException
		{
		String[] m = sp.modelNamesList();
		String[] b = sp.bikePricesList();
		String[] l = sp.launchDatesList();
		
		String[] mNames = new String[m.length];
		String[] bPrices = new String[b.length];
		String[] lDates = new String[l.length];
		int j=0;
		for(int i=0;i<b.length;i++) {
			String p = b[i].replaceAll("[^\\d]", "");
			int price = (int) Integer.parseInt(p);
			if(b[i].contains("Lakh")) {
				price = price*1000;
			}
			if(price < 400000) {
				mNames[j] = m[i];
				bPrices[j] = b[i];
				lDates[j] = l[i];
				j++;
			}
		}
		excel.setdata(mNames,bPrices,lDates);
		System.out.println(Arrays.toString(mNames));
	
//		for(int i=0;i<mNames.length;i++)
//		{
//			excel.setdata("sheet1",i,mNames[i]);
//		}
		System.out.println(Arrays.toString(bPrices));
		System.out.println(Arrays.toString(lDates));
		
	
	}
	@Test(priority=8,groups= {"regression"})
	public void navghp()
	{
		sp=new SecondPage(driver);
		sp.navigatingback();
		logger.info("navigating back to home page");
		
	}
	@Test(priority = 9,groups= {"regression"})
	public void popm()
	{
		logger.info("Selecting used bikes in chennai");
		thirdpage tp=new thirdpage(driver);
		fp.usedcars();
		logger.info("selcting used bikes");
		
	}
	@Test(priority = 10 ,groups= {"regression"})
	public void selcityaschn()
	{
		fp.selectcity();
		logger.info("Selecting city");
	}
	@Test(priority = 11,groups= {"regression"})
	public void scroillingucpm()
	{
		thirdpage tp=new thirdpage(driver);
		tp.scroll();
		logger.info("scrolling upto popular models");
		
	}
	@Test(priority = 12 ,groups= {"regression"})
	public void printpm() throws IOException
	{
		thirdpage tp=new thirdpage(driver);
		tp.popmodels();
		logger.info("printing popular models");
		
	}
	@Test(priority=13,groups= {"regression"})
	public void navghp2()
	{
		logger.info("validating user deatils");
	    sp.navigatingback();
	    logger.info("navigating back to home page");
	   
	   
	}
	@Test(priority=14,groups= {"regression"})
	public void getlogo()
	{
		fp=new Homepage(driver);
		fp.gettxt();
		
	}
	@Test(priority=15,groups= {"regression"})
	public void registering()
	{
		 fp.logsign();
		 logger.info("selcting login/signup");
		
	}
	@Test(priority=16,groups= {"regression"})
	public void selectinggoogle()
	{
		fp.selectgoogle();
	    logger.info("select google");
	}
	@Test(priority=17,groups= {"sanity"})
	
	public void reg() throws IOException
	{
		lp=new loginpage(driver);

			Set <String> Window = driver.getWindowHandles();
		    List <String> Window1 = new ArrayList<String>(Window); 
		    driver.switchTo().window(Window1.get(1));
		    
		    
		logger.info("entering details");

		lp.enteremail();
		logger.info("entering invalid emil id");
	}
	@Test(priority=18 ,groups= {"sanity"})
	public void clknb()
	{
		lp=new loginpage(driver);
		lp.nextbutton();
		logger.info("clicking next button");
	}
	@Test(priority = 19 ,groups= {"regression"})
	public void getemess()
	{
		lp=new loginpage(driver);
		lp.geterrormsg();
		logger.info("validating error message");
	
		logger.error("test failed...");
	
		logger.info("****** finishedtestcase_zigwheels01 ******" );

	}
		
	
}
