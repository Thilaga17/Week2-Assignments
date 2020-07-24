package week2.day2.assignments;

import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.chrome.ChromeDriver;

public class GoToHomePage {

	public static void main(String[] args) throws InterruptedException, URISyntaxException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		
		//1. Click on Go To Home Page
		driver.findElementByLinkText("Go to Home Page").click();
		driver.navigate().back();
		String Link1 = driver.findElementByLinkText("Go to Home Page").getAttribute("href");
		System.out.println("The first home page link(Link1) is : " + Link1);
		
		//4. Goto Home Page (Interact with the same link)
		driver.findElementByXPath("//label[text() = '(Interact with same link name)']/preceding::a[1]").click();
		driver.navigate().back();
		String Link2 = driver.findElementByXPath("//label[text() = '(Interact with same link name)']/preceding::a[1]").getAttribute("href");
		Thread.sleep(3000);
		System.out.println("The second home page link(Link2) is : " + Link2);
		
		URI url1 = new URI(Link1);
		URI url2 = new URI(Link2);
		if(url1.equals(url2))
		{
			System.out.println("Home Page Link " + Link1);
		}
		
	}

}
