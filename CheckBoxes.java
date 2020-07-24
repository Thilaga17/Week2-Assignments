package week2.day2.assignments;

import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxes {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get(" http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		
		// Select the languages that you know
		driver.findElementByXPath("//label[text() = 'Select the languages that you know?']/following::input[1]").click();
		driver.findElementByXPath("//label[text() = 'Select the languages that you know?']/following::input[4]").click();
		driver.findElementByXPath("//label[text() = 'Select the languages that you know?']/following::input[5]").click();

		// Confirm Selenium is checked
		boolean value = driver.findElementByXPath("//label[text() = 'Confirm Selenium is checked']/following::input[1]").isSelected();
		System.out.println("Selenium is checked - " + value);
		
		//DeSelect only checked
		boolean value1 = driver.findElementByXPath("//label[text() = 'DeSelect only checked']/following::input[2]").isSelected();
		if(value1 == true)
		{
			driver.findElementByXPath("//label[text() = 'DeSelect only checked']/following::input[2]").click();
		}
		
		//Select all below checkboxes
		driver.findElementByXPath("//label[text() = 'Select all below checkboxes ']/following::input[1]").click();
		driver.findElementByXPath("//label[text() = 'Select all below checkboxes ']/following::input[2]").click();
		driver.findElementByXPath("//label[text() = 'Select all below checkboxes ']/following::input[3]").click();
		driver.findElementByXPath("//label[text() = 'Select all below checkboxes ']/following::input[4]").click();
		driver.findElementByXPath("//label[text() = 'Select all below checkboxes ']/following::input[5]").click();
		
	}

}
