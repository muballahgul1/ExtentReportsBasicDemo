package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicDemo {

	public static void main(String[] args) {
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("extentReport.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test=extent.createTest("Google seartch test ","this validate google seartch functionality");
		System.setProperty("webdriver.chrome.driver", "C://webdrivers//chromedriver.exe");
		//ChromeOptions option=new ChromeOptions();
		//option.setHeadless(true);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		test.log(Status.INFO, "Test case Starting");
		driver.get("https://www.google.com/");
		test.pass("Navigate to googl.com");
		driver.findElement(By.name("q")).sendKeys("Automation");
		test.pass("Entered text into searchbox");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test.pass("Pressed keyboard enter key");
		//driver.close();
		driver.quit();
		test.pass("Close the Browser");
		test.info("Test is completed");
		extent.flush();
		

	}

}
