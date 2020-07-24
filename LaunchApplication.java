//CREATE THE LEADS

package week2.day1.assignments;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LaunchApplication
{

	public static void main(String[] args)
	{
		// to set the path for the driver.
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		// create object for ChromeDriver class - To open/invoke the chrome browser only.		
		ChromeDriver driver = new ChromeDriver();
		// ChromeDriver class is having certain methods, to use those methods creation of object is mandatory.
		
		// To invoke any browsers, Have to use Interface WebDriver.
		// WebDriver driver = new ChromeDriver();		
		
		// Load the URL, use the method driver.get();
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		// To maximize the window
		driver.manage().window().maximize();
		
		// To close the browser
		//driver.close();
		
		//Typing a UserName
		WebElement eleUserName = driver.findElementById("username");
		eleUserName.sendKeys("demosalesmanager");
		
		//Typing a PassWord
		WebElement elePassWord = driver.findElementByName("PASSWORD");
		elePassWord.sendKeys("crmsfa");
		
		//Clicking a login button:
		driver.findElementByClassName("decorativeSubmit").click();
		
		//Clicking a CRM/SFA button:
		driver.findElementByLinkText("CRM/SFA").click();
		
		//Opening Leads icon:
		driver.findElementByLinkText("Leads").click();
		
		//CLicking on Create Lead option
		driver.findElementByLinkText("Create Lead").click();
		
		//Typing a company name
		driver.findElementById("createLeadForm_companyName").sendKeys("TestLeafSolutions");
		
		//Typing a Firstname
		driver.findElementById("createLeadForm_firstName").sendKeys("Thilaga");
		
		//Typing a lastname
		driver.findElementById("createLeadForm_lastName").sendKeys("K");
		
		//Selecting "Employee" in source dropDown field by using VisibleText
		WebElement source = driver.findElementById("createLeadForm_dataSourceId");		
		Select dropDown = new Select(source);
		dropDown.selectByVisibleText("Employee");
		
		//Selecting "Pay Per Click Advertising" in marketingCampaignId using selectByValue:
		WebElement marketingcampaign = driver.findElementById("createLeadForm_marketingCampaignId");
		Select dropDown1 = new Select(marketingcampaign);
		dropDown1.selectByValue("9001");
		
		//Selecting "Telecommunications" in Industry using SelectByIndex
		WebElement industry = driver.findElementById("createLeadForm_industryEnumId");
		Select dropDown2 = new Select(industry);			// Selecting Industry Field
		List<WebElement> options = dropDown2.getOptions();  // Listing the  child elements from parent element(Industry).
		int size = options.size();							// Counting the child elements.
		dropDown2.selectByIndex(size - 2);
		
		//Selecting Corporation in OwnerShip field Using SelectbyIndex
		WebElement ownerShip = driver.findElementById("createLeadForm_ownershipEnumId");
		Select dropDown3 = new Select(ownerShip);
		List<WebElement> options1 = dropDown3.getOptions();
		int size1 = options1.size();
		dropDown3.selectByIndex(size1 -2);
		
		driver.findElementByXPath("//input[@id = 'createLeadForm_primaryPhoneCountryCode']").clear();
		driver.findElementByXPath("//input[@id = 'createLeadForm_primaryPhoneCountryCode']").sendKeys("+91");
		driver.findElementByXPath("//input[@id = 'createLeadForm_primaryPhoneNumber']").sendKeys("6380466792");
		driver.findElementByXPath("//input[@id = 'createLeadForm_primaryEmail']").sendKeys("thilagasabhaa@gmail.com");
		
		//Selecting India in Country Field Using SelectbyVisibletext
		WebElement country = driver.findElementById("createLeadForm_generalCountryGeoId");
		Select dropDown4 = new Select(country);
		dropDown4.selectByVisibleText("India");
		
		// Click on createLead button
		driver.findElementByClassName("smallSubmit").click();
		
		// Getting the title of the return page
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.close();
		
	}
}
