package week2.day2.assignments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

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
		
		driver.findElementByXPath("//ul[@class = 'x-tab-strip x-tab-strip-top']/li[2]").click();
		
		driver.findElementByXPath("//input[@name = 'phoneCountryCode']").clear();
		driver.findElementByXPath("//input[@name = 'phoneCountryCode']").sendKeys("+91");
		driver.findElementByXPath("//input[@name = 'phoneNumber']").sendKeys("6380466792");
		driver.findElementByXPath("//button[text() = 'Find Leads']").click();
		Thread.sleep(3000);
		
		String LeadsId = driver.findElementByXPath("//div[@class = 'x-grid3-body']//a").getText();
		System.out.println("The Lead Id is - " + LeadsId);
		driver.findElementByXPath("//div[@class = 'x-grid3-body']//a").click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("//a[text() = 'Delete']").click();
		
		//Verify the id was deleted
		driver.findElementByXPath("//a[text() = 'Find Leads' ]").click();
		driver.findElementByXPath("//input[@name ='id']").sendKeys(LeadsId);
		driver.findElementByXPath("//button[text() = 'Find Leads']").click();
		Thread.sleep(3000);
		String text = driver.findElementByXPath("//div[@class = 'x-paging-info']").getText();
		System.out.println(text);
		String ActualText = "No records to display";
		if(text.equals(ActualText))
		{
			System.out.println(LeadsId + " was deleted Successfully ");	
		}
	
	    driver.close();
		}

}
