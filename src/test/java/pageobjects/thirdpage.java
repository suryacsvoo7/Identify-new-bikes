package pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.excel;

public class thirdpage extends basepage{
	
	JavascriptExecutor js;
	
	public thirdpage(WebDriver driver)
	{
		super(driver);
		js =  (JavascriptExecutor)driver; 
	}
	@FindBy(xpath="/html/body/div[7]/div/div[1]/div[1]/div[1]/div[2]/ul/li[2]/div[2]/div[4]")
	WebElement pmodels;
    @FindBy(xpath="//*[@class='zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']")
    List<WebElement> popularmodels;



public void scroll()
{
	js.executeScript("arguments[0].scrollIntoView();" ,pmodels);
	
	
	
	
}
public void popmodels() throws IOException
{
	String[] data = new String[popularmodels.size()];
	for(int i=0;i<popularmodels.size();i++) {
		data[i] = popularmodels.get(i).getText();
		System.out.println(data[i]);
	}
	excel.setdata(data);
}


}
