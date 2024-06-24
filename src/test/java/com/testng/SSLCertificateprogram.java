package com.testng;
import org.testng.annotations.*;

import com.screenshots.TakesScreenshots;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.*;
public class SSLCertificateprogram {
	WebDriver driver;
	String url="https://expired.badssl.com/";
	
	@BeforeMethod
	public void launch() {
		EdgeOptions edge=new EdgeOptions();
		edge.addArguments("--remote-allow-origins=*");
		edge.setAcceptInsecureCerts(true);
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver(edge);
		driver.manage().window().maximize();
	}
	
	@Test
	public void run() {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		TakesScreenshots.takesScreenshot(driver, "sslcertificate");
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}

}
