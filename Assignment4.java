package week2.day2.assignments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		WebElement username = driver.findElementByXPath("//input[@id = 'username']");
		username.sendKeys("demosalesmanager");
		
		WebElement passWord = driver.findElementByXPath("//input[@id = 'password']");
		passWord.sendKeys("crmsfa");
		
		WebElement login = driver.findElementByXPath("//input[@class = 'decorativeSubmit']");
		login.click();
		
		driver.findElementByXPath("//a[text()[normalize-space() = 'CRM/SFA']]").click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("//a[text() = 'Leads']").click();
				
		driver.findElementByXPath("//a[text() = 'Find Leads' ]").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//span[text() = 'Email']").click();
		driver.findElementByXPath("//input[@name= 'emailAddress']").sendKeys("thilagasabhaa@gmail.com");
		driver.findElementByXPath("//button[text() = 'Find Leads']").click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("//div[@class= 'x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		
		String Name = driver.findElementByXPath("//span[@id = 'viewLead_firstName_sp']").getText();
		System.out.println("Name of the Lead is " + Name);
		
		driver.findElementByXPath("//a[text() = 'Duplicate Lead']").click();
		
		String Title = driver.findElementByXPath("//div[@id = 'sectionHeaderTitle_leads']").getText();
		System.out.println("The TITLE of the duplicate lead page is " + Title);
		
		driver.findElementByXPath("//input[@value = 'Create Lead' and @name = 'submitButton']").click();
		
		String DuplicateName = driver.findElementByXPath("//span[@id ='viewLead_firstName_sp']").getText();
		System.out.println("The duplicate name of the lead is " + DuplicateName );
		if (Name.equals(DuplicateName))
		{
			System.out.println("Both Actual name and Duplicate Name of the lead is same");
		}
		
		driver.close();		
		
	}

}
