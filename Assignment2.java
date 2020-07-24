package week2.day2.assignments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException
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
		
		// Username field
		WebElement username = driver.findElementByXPath("//input[@id = 'username']");
		username.sendKeys("demosalesmanager");
		
		//Password field
		WebElement passWord = driver.findElementByXPath("//input[@id = 'password']");
		passWord.sendKeys("crmsfa");
		
		//Click on login button
		WebElement login = driver.findElementByXPath("//input[@class = 'decorativeSubmit']");
		login.click();
		
		//CLick on CRM/SFA 
		driver.findElementByXPath("//a[text()[normalize-space() = 'CRM/SFA']]").click();
		Thread.sleep(3000);

		//Click on Leads icon
		driver.findElementByXPath("//a[text() = 'Leads']").click();
		
		//Clicks on Find leads
		driver.findElementByXPath("//a[text() = 'Find Leads' ]").click();
		Thread.sleep(2000);
		
		//Entering First Name		
		driver.findElementByXPath("//div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']//input[@type='text' and @name ='firstName']").sendKeys("Thilaga");
		
		//Click on FindLeads
		driver.findElementByXPath("//button[@class ='x-btn-text' and text() = 'Find Leads' ]").click();
		Thread.sleep(3000);
		
		//CLick on first resulting lead
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a").click();	
		Thread.sleep(3000);
			
		//Validate the title
		String title = driver.getTitle();
		String Expected = "View Lead | opentaps CRM";
		
		if(title.equals(Expected))
		{
			System.out.println("Title is correct");
		}
		else
		{
			System.out.println("Title is wrong");
		}
		
		// Click on Edit button
		driver.findElementByXPath("//a[text() ='Edit']").click();
		
		//Change the company name
		driver.findElementByXPath("//input[@id = 'updateLeadForm_companyName']").clear();
		driver.findElementByXPath("//input[@id = 'updateLeadForm_companyName']").sendKeys("L&T Infotech");
		
		//CLick on update button
		driver.findElementByXPath("//input[@name ='submitButton' and @value = 'Update']").click();
		
		//Confirm the changed name appears
		String NewCompanyName = driver.findElementByXPath("//span[@id = 'viewLead_companyName_sp']").getText();
		System.out.println("Company Name was changed to - " + NewCompanyName);
		
		driver.close();
				
		
	}

}
