package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.excel;

public class loginpage extends basepage{
	WebDriver driver;
	public loginpage(WebDriver driver)
	{
		super(driver);
	}
@FindBy(xpath="//*[@id='identifierId']")
WebElement emailid;
//@FindBy(xpath="//*[@id='identifierNext']/div/button/span")
@FindBy(xpath="//span[text()=\"Next\"]")
WebElement nxtbtn;
@FindBy(xpath="//*[@id='yDmH0d']/c-wiz/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]/div")
//@FindBy(xpath="//div[@class=\"o6cuMc Jj6Lae\"]")
WebElement errormessage;


public void enteremail() throws IOException
{
	String data=excel.getdata("sheet1",0,0);
	System.out.println(data);
	emailid.sendKeys(data);
}


//public void geterrormsg()
//{
//	errormessage.getText();
//}
public void nextbutton()
{
	nxtbtn.click();
}
public void geterrormsg()
{
	errormessage.getText();
}


}
