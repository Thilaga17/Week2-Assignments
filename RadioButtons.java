package week2.day2.assignments;

import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		
		//Are you enjoying the classes? 
		driver.findElementByXPath("//input[@class ='myradio' and @id ='yes']").click();
		
		//Find default selected radio button
		boolean Value = driver.findElementByXPath("//input[@value = '1' and @name ='news']").isSelected();
		if(Value == true)
		{
		System.out.println("By Default Checked radio button was selected");
		}
		
		//Select your age group (Only if choice wasn't selected)
		boolean age = driver.findElementByXPath("//input[@type = 'radio' and @checked ='' and @name ='age']").isSelected();
		if(age == true)
		{
			System.out.println("My Age was selected already");
		}
		
		driver.close();
		

	}

}
