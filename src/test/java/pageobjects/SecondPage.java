package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SecondPage extends basepage {
	WebDriver driver;
	public SecondPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(name="makeId")
	WebElement drpdown;
	@FindBy(xpath="/html/body/main/div/div/div[1]/div[1]/div[1]/div/div[2]/span/span")
    WebElement RDmore;
	@FindBy(xpath="//tr[@class='ml-15 ']//td[1]")
	List<WebElement> modelnames;
	@FindBy(xpath="//tr[@class='ml-15 ']//td[2]")
	List<WebElement> bikeprices;
	@FindBy(xpath="//tr[@class='ml-15 ']//td[3]")
	List<WebElement> launchdates;
	@FindBy(xpath="//*[@id='Header']/div/div[1]/div[1]/a/img")
	WebElement header;
	public void dropdown()
	{
		drpdown.click();
	}
	public void Honda()
	{
		Select hondabrand=new Select(drpdown);
		hondabrand.selectByVisibleText("Honda");
	}
	public void readm()
	{
		RDmore.click();
	}
		
	public String[] modelNamesList() {
		String[] mNames = new String[modelnames.size()];
		for(int i=0;i<mNames.length;i++) {
			mNames[i] = modelnames.get(i).getText();
		}
		return mNames;
	}
	
	public String[] bikePricesList() {
		String[] bPrices = new String[bikeprices.size()];
		for(int i=0;i<bPrices.length;i++) {
			bPrices[i] = bikeprices.get(i).getText();
		}
		return bPrices;
	}
	
	public String[] launchDatesList() {
		String[] lDates = new String[launchdates.size()];
		for(int i=0;i<lDates.length;i++) {
			lDates[i] = launchdates.get(i).getText();
		}
		return lDates;
	}
	
	public void navigatingback()
	{
		header.click();
	}
	
}
