package stepdefinationfile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Homepage;
import pageobjects.SecondPage;
import pageobjects.basepage;
import pageobjects.loginpage;
import pageobjects.thirdpage;
import testbase.baseclass;
import testcase.testcase_zigwheels01;
import utilities.excel;

public class steps {
	public Homepage fp;
	public SecondPage sp;
	public loginpage lp;
	public static Logger logger;
	public static WebDriver driver;
	@Given("The user is on zigwheels Homepage")
	public void the_user_is_on_zigwheels_homepage() throws IOException {
		driver = hooks.driver;
		logger = hooks.logger;
		fp=new Homepage(driver);
		fp.gettxt();

	}

	@When("the user moves the mouse to the NewBikes")
	public void the_user_moves_the_mouse_to_the_new_bikes() {
		fp=new Homepage(driver);
		fp.Ncars();
		
	}

	@Then("Select UpcomingCars")
	public void select_upcoming_cars() {
		fp=new Homepage(driver);
		fp.upcomoingbikes();
	}

	@Given("the user is on upcoming bikes page")
	public void the_user_is_on_upcoming_bikes_page() {
		fp=new Homepage(driver);
		fp.gettxt();
		
	}

	@When("Select honda brand in manufacturer dropdown")
	public void select_honda_brand_in_manufacturer_dropdown() throws IOException {
		sp=new SecondPage(driver);
		sp.dropdown();
		sp.Honda();
	}

	@When("click Readmore")
	public void click_readmore() {
		sp=new SecondPage(driver);
		sp.readm();
	}

	@Then("print the bikes names,price,launched dates whose price less than 4lakhs")
	public void print_the_bikes_names_price_launched_dates_whose_price_less_than_4lakhs() throws IOException {
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

	@Given("navigating to Homepage")
	public void navigating_to_homepage() {
		sp=new SecondPage(driver);
		sp.navigatingback();
	}

	@When("the user moves mouse to the used cars")
	public void the_user_moves_mouse_to_the_used_cars() {
		thirdpage tp=new thirdpage(driver);
		fp=new Homepage(driver);
		fp.usedcars();
		

	}

	@When("Select Chennai in city section")
	public void select_chennai_in_city_section() {
		fp.selectcity();
	}

	@When("scroll down to the popular models")
	public void scroll_down_to_the_popular_models() {
		thirdpage tp=new thirdpage(driver);
		tp.scroll();
	}

	@Then("print popular models list")
	public void print_popular_models_list() throws IOException {
		thirdpage tp=new thirdpage(driver);
		tp.popmodels();
	}

	@Given("login\\/sinup page is opened")
	public void login_sinup_page_is_opened() {
		sp=new SecondPage(driver);
		sp.navigatingback();
	    
	}

	@When("Select login\\/signup")
	public void select_login_signup()  {
		fp=new Homepage(driver);
		fp.logsign();
	    
	    
	

	
	
	   
	}

	@When("Select google")
	public void select_google() {
		fp=new Homepage(driver);
		fp.selectgoogle();

	   
	}

	@When("enter Invalid Email-Id")
	public void enter_invalid_email_id() throws IOException {
		lp=new loginpage(driver);

		Set <String> Window = driver.getWindowHandles();
	    List <String> Window1 = new ArrayList<String>(Window); 
	    driver.switchTo().window(Window1.get(1));
	    
	    
	

	lp.enteremail();

		
	    
	}

	@Then("get the error messgae")
	public void get_the_error_messgae() {
		lp=new loginpage(driver);
		lp.nextbutton();
		lp.geterrormsg();
	    
	}




}
