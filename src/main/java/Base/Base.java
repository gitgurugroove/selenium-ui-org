package Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {
	public static WebDriver driver;
	public static Properties prop;
	
	//To call different browsers
	public void driverSetup()
	{
		prop=new Properties();
		
		try 
		{
			prop.load(new FileInputStream("src/main/java/Config/config.properties"));
		}	
		 catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		//To Open Chrome Browser
		if(prop.getProperty("browserName").matches("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		//To Open Firefox Browser
		if(prop.getProperty("browserName").matches("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		
		//To maximize the Browser Window
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
	

}
