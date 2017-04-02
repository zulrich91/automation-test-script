import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.security.spec.EncodedKeySpec;
import java.util.concurrent.TimeUnit;

import org.apache.http.entity.mime.MIME;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.screenrecorder.ScreenRecorder.State;
import org.monte.screenrecorder.*;
import org.monte.media.audio.*;
import org.monte.media.VideoFormatKeys.*;
import org.monte.media.math.Rational;
import org.omg.IOP.ENCODING_CDR_ENCAPS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gargoylesoftware.htmlunit.PluginConfiguration.MimeType;

import java.awt.*;

import javax.print.attribute.standard.Compression;


public class DriverRecorder {
	
	private static org.monte.screenrecorder.ScreenRecorder screen;
	
	public static void main(String[] args) throws IOException, AWTException {
		GraphicsConfiguration gconfig = GraphicsEnvironment
										.getLocalGraphicsEnvironment()
										.getDefaultScreenDevice()
										.getDefaultConfiguration();
//		screenRecorder = new ScreenRecorder(gconfig,
//											new Format(MediaTypeKey , MediaType.FILE , MimeTypeKey,MIME_AVI),
//											new Format(MediaTypeKey , MediaType.VIDEO , EncodingKey,ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, CompressorNameKey,
//											ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE , DepthKey , (int)24 , FrameRateKey , Rational.valueOf(15),
//									        QualityKey , 1.0f , KeyFrameIntervalKey , (int) (15*60)),
//										    new Format(MediaTypeKey , MediaType.VIDEO , EncodingKey ,"black", 
//										    FrameRateKey, Rational.valueOf(30)),null);
		
		WebDriver driver = new FirefoxDriver();
		
		// Start Capturing the Video
		screen = new org.monte.screenrecorder.ScreenRecorder(gconfig);
		screen.start();
		
		//Puts an implicit wait.Will wait for 10 seconds
		// before throwing exceptions
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		// Launch Website
		driver.get("http://127.0.0.1:8888/page/instructorHomePage");
//		driver.navigate().to("http://127.0.0.1:8888/");
		
		// Maximise the Browser
		driver.manage().window().maximize();
		
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
		
		System.out.println("Browse will be closing in less than 20 seconds");
		
		// Defines implicit time for the browser to close
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.close();
	
		screen.stop();
		
	}
}
