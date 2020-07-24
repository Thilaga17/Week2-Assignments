package week2.day2.assignments;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountingLinks {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		
		//1. Capture all links in the website
		List<WebElement>links =  driver.findElementsByTagName("a");
		
		//2. Count and display no. of links
		System.out.println("Number of links available in the Webpage(http://leafground.com/pages/Link.html) is : " + links.size());
		driver.close();
		
		

	}

}
