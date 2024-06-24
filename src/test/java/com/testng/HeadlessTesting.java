package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.screenshots.TakesScreenshots;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessTesting {
WebDriver driver;
String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

@BeforeClass
public void lunch() {
	//approach1 headless mode
//	EdgeOptions edge=new EdgeOptions();
//	edge.addArguments("--remote-allow-origins=*");
//	edge.setHeadless(true);
//	WebDriverManager.edgedriver().setup();
//	driver=new EdgeDriver(edge);
//	driver.manage().window().maximize();
	
	//approach2 webdrivermanager
	EdgeOptions edge=new EdgeOptions();
	edge.addArguments("--remote-allow-origins=*");
	//edge.setHeadless(true);
driver=WebDriverManager.edgedriver().capabilities(edge).create();
driver.manage().window().maximize();
}

@Test
public void runTest() {
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	WebElement user=driver.findElement(By.xpath("//input[@placeholder='Username']"));
	user.sendKeys("Admin");
	
	
	WebElement pass=driver.findElement(By.xpath("//input[@placeholder='Password']"));
	pass.sendKeys("admin123");
	
	
	WebElement subm=driver.findElement(By.xpath("//button[@type='submit']"));
	
	subm.click();
	
	String actual=driver.getTitle();
	String Expect="OrangeHRM";
	
	if(actual.contains(Expect)) {
		System.out.println("login test is passed");
	}else {
		System.out.println("login test is fail");
	}
	
//	System.out.println("title of the page: " + driver.getTitle());
	

}

@AfterClass
public void teardown() {
	driver.close();
}
}
