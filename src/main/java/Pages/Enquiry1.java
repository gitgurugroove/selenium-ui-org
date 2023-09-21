package Pages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import Base.Base;

public class Enquiry1 extends Base{
	WebDriverWait wait;

	//To Open the URL
    public void OpenUrl(){
		
		driver.get("https://www.ishahomes.com/");
	}
    public void projects() throws InterruptedException, IOException {

    	wait = new WebDriverWait(driver,30);
    	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='close']")));
    	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@class='close']")));
    	Thread.sleep(7000);
		WebElement element =driver.findElement(By.xpath("//html[1]/body[1]/div[5]/div[1]/button[1]"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();",element);
		Thread.sleep(3000);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("livchat_close")));
    	driver.findElement(By.id("livchat_close")).click();
    	Thread.sleep(3000);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Completed Projects']")));
    	driver.findElement(By.xpath("//span[text()='Completed Projects']")).click();
    	Thread.sleep(2000);
    	WebElement element2 = driver.findElement(By.xpath("//span[text()='Apartments']"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
    	Thread.sleep(1000);
    	WebElement element1 = driver.findElement(By.xpath("//span[text()='Villas']"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
    	Thread.sleep(1000);
		WebElement ele2=driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[2]/p[2]"));
		jse.executeScript("arguments[0].scrollIntoView();",ele2);
    	Thread.sleep(3000);
    	List<WebElement> prj = driver.findElements(By.xpath("//*[@id='bg']/div[1]/section[2]/div/div/div/div/div/h5/a"));
    	System.out.println("Total completed Projects: "+prj.size());
    	for(int i=0;i<5;i++){
			System.out.println(prj.get(i).getText());
		}
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Enquire Now')]")));
    	driver.findElement(By.xpath("//div[contains(text(),'Enquire Now')]")).click();
    	if(driver.getPageSource().contains("Contact Info")) {
    		System.out.println("Contact Info is Present");
    	}else {
    		System.out.println("Contact Info is not Present");
    	}
    	Thread.sleep(3000);
    	String email=driver.findElement(By.xpath("//*[@id='bg']/div[2]/div/div/div[2]/div[3]/div[2]/p/a")).getText();
    	System.out.println("Email: "+email);
    	TakesScreenshot capture = (TakesScreenshot) driver;
		File srcFile = capture.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")
				+ "/Screenshot/Contact.png");
		Files.copy(srcFile, destFile);
    	Thread.sleep(3000);
    }
    
  //To execute all methods
  	public static void main(String[] args) throws InterruptedException, IOException{
  		Enquiry1 s= new Enquiry1();
  		s.driverSetup();
  		s.OpenUrl();
  		s.projects();
  		s.OpenUrl();
  		s.closeBrowser();
  	}
}
