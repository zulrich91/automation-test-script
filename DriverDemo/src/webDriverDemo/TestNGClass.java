/**
 * 
 */
package webDriverDemo;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * @author ulrich
 *
 */
public class TestNGClass {
	
	private WebDriver driver;
	private String URL = "http://127.0.0.1:8888/page/instructorHomePage";
	/**
	 * @param args
	 */
	@Parameters("browser")
	@BeforeTest
	public void launchApp(String browser){
		
		if(browser.equalsIgnoreCase("firefox")) {
			System.out.println("Executing on Firefox");
			driver = new FirefoxDriver();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		else if (browser.equalsIgnoreCase("chrome")){
			System.out.println("Executing on CHROME");
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		else if (browser.equalsIgnoreCase("ie")) {
			System.out.println("Executing on Internet Explorer");
			System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		else {
			throw new IllegalArgumentException("The Browser Type is underfined");
		}

	}
	
	@Test
	public void LoadPages() {
		WebElement element = driver.findElement(By.xpath(".//*[@id='email']"));
		element.clear();
		element.sendKeys("ulrichmobi2@gmail.com");
		String email = driver.findElement(By.xpath(".//*[@id='email']")).getAttribute("value");
		System.out.println("Your email is " + email);
//		driver.findElement(By.id("isAdmin")).click();
		driver.findElement(By.id("isAdmin")).click();
		//driver.findElement(By.id("isAdmin")).isSelected();
//		System.out.println("The output of isSelected is " + driver.findElement(By.id("isAdmin")).isSelected() );
//		System.out.println("The output of isEnabled is " + driver.findElement(By.id("isAdmin")).isEnabled() );
//		System.out.println("The output of isSelected is " + driver.findElement(By.id("isAdmin")).isDisplayed() );
		driver.findElement(By.xpath(".//*[@id='btn-login']")).click();
//		WebDriver driver2 = new FirefoxDriver();
//		driver2.get("http://127.0.0.1:8888/page/instructorHomePage");
		driver.findElement(By.id("addNewCourse")).click();
		driver.findElement(By.xpath(".//*[@id='courseid']")).sendKeys("CEF_500");
		driver.findElement(By.xpath(".//*[@id='coursename']")).sendKeys("Python Programming");
		driver.findElement(By.xpath(".//*[@id='btnAddCourse']")).click();
		
//		File screenshot	= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		
//		FileUtils.copyFile(screenshot,new File("C:\\screenshots\\screenshots.jpg") );
		System.out.println("Browser will be closing in less than 20 seconds");
		
		// Defines implicit time for the browser to close
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterTest 
	public void closeBrowser()
	{
		driver.close();
	}

}
