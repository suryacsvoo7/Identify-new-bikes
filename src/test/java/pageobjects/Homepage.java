package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Homepage extends basepage{
	Actions action;
	public Homepage(WebDriver driver)
	{
	        super(driver);
			action =new Actions(driver);
	}
	
	@FindBy(linkText="New Bikes")
	WebElement NewCars;
	@FindBy(xpath="//span[text()='Upcoming Bikes']")
	WebElement UpBikes;

   // @FindBy(linkText="Used Cars")
	@FindBy(xpath="//a[@class=\"c-p\"][text()=\"Used Cars\"]")
	WebElement ucars;
	@FindBy(xpath="//*[@id=\'headerNewNavWrap\']/nav/div/ul/li[7]/ul/li/div[2]/ul/li[4]/span")
	WebElement city;
	
	@FindBy(xpath="//*[@id='Header']/div/div[1]/div[1]/a/img")
	WebElement logo;
	
	//@FindBy(xpath="//*[@id='forum_login_title_lg']")
	@FindBy(xpath="//div[@id=\"des_lIcon\"]")
	WebElement login;
	//@FindBy(xpath="//*[@id='myModal3-modal-content']/div[1]/div/div[3]/div[6]/div")
	@FindBy(xpath="//span[@class=\"fnt-14\"][text()=\"Google\"]")
    WebElement google;

	
	
	
	public void Ncars()
	{
		action.moveToElement(NewCars).perform();
		
	}
	public void upcomoingbikes()
	{
		UpBikes.click();
	}

public void usedcars()
{
	action.moveToElement(ucars).perform();
	
}
public void selectcity()
{
	city.click();
}
public void gettxt()
{
	logo.getText();
	}
public void logsign()
{
	login.click();
}
public void selectgoogle()
{
	google.click();
	
}
	
	
}
