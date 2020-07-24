/* Link Page assignments
 * 2. Find Where am supposed to go without clicking me
 * 3. Verify Am I broken?
*/

package week2.day2.assignments;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		
		//2.Find where am supposed to go without clicking me? 
		String link = driver.findElementByLinkText("Find where am supposed to go without clicking me?").getAttribute("href");
		System.out.println("The link is" + link);
		
		//3.Verify Am I broken 
	
		String url = driver.findElementByLinkText("Verify am I broken?").getAttribute("href"); // Getting att value href and storing in "url".
		System.out.println("The value of href attribute is" + url);							   // Print the att value
		URL urllink = new URL(url);	
		HttpURLConnection httpconn = (HttpURLConnection) urllink.openConnection();			   // Create a connection using urllink	
		Thread.sleep(3000);
		httpconn.connect();																   // Establish a connection using connect() method
		int resCode = httpconn.getResponseCode();
		
		if(resCode>=400)
		{
			System.out.println(url + "-" + "is a broken link");
		}
		else
		{
			System.out.println(url + "-" + "is a valid link");
		}
		driver.close();
	}
}
