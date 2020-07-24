package week2.day2.assignments;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonPage {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		
		driver.findElementById("email").sendKeys("thilsresponsive@gmail.com");
		
		driver.findElementByXPath("//input[@value = 'Append ']").sendKeys("123");
		driver.findElementByXPath("//input[@value = 'Append ']").sendKeys(Keys.TAB);
		
		String attribute = driver.findElementByName("username").getAttribute("value");
		System.out.println(attribute);
		
		driver.findElementByXPath("//label[text() = 'Clear the text']/following::input").clear();
		
		boolean value = driver.findElementByXPath("//input[@disabled = 'true']").isEnabled();
		System.out.println(value);
		
		driver.close();
	
	}

}
