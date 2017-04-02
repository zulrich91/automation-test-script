/**
 * 
 */
package webDriverDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gargoylesoftware.htmlunit.javascript.configuration.WebBrowser;

/**
 * @author ulrich
 *
 */
public class DriverDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	WebDriver driver = new FirefoxDriver();
	
	
	//Puts an implicit wait.Will wait for 10 seconds
	// before throwing exceptions
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	// Launch Website
	driver.get("http://127.0.0.1:8888/page/instructorHomePage");
//	driver.navigate().to("http://127.0.0.1:8888/");
	
	// Maximise the Browser
	driver.manage().window().maximize();
	
	WebElement element = driver.findElement(By.xpath(".//*[@id='email']"));
	element.clear();
	element.sendKeys("ulrichmobi2@gmail.com");
	String email = driver.findElement(By.xpath(".//*[@id='email']")).getAttribute("value");
	System.out.println("Your email is " + email);
//	driver.findElement(By.id("isAdmin")).click();
	driver.findElement(By.id("isAdmin")).click();
	//driver.findElement(By.id("isAdmin")).isSelected();
//	System.out.println("The output of isSelected is " + driver.findElement(By.id("isAdmin")).isSelected() );
//	System.out.println("The output of isEnabled is " + driver.findElement(By.id("isAdmin")).isEnabled() );
//	System.out.println("The output of isSelected is " + driver.findElement(By.id("isAdmin")).isDisplayed() );
	driver.findElement(By.xpath(".//*[@id='btn-login']")).click();
//	WebDriver driver2 = new FirefoxDriver();
//	driver2.get("http://127.0.0.1:8888/page/instructorHomePage");
	driver.findElement(By.id("addNewCourse")).click();
	driver.findElement(By.xpath(".//*[@id='courseid']")).sendKeys("CEF_500");
	driver.findElement(By.xpath(".//*[@id='coursename']")).sendKeys("Python Programming");
	driver.findElement(By.xpath(".//*[@id='btnAddCourse']")).click();
	
	System.out.println("Browse will be closing in less than 20 seconds");
	// Defines implicit time for the browser to close
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.close();
	
	
	}

}
