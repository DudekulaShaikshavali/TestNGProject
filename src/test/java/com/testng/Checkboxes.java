package com.testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.screenshots.TakesScreenshots;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkboxes {
WebDriver driver;
String url="https://demo.guru99.com/test/radio.html";

@BeforeTest
public void launch() {
	EdgeOptions edge=new EdgeOptions();
	edge.addArguments("--remote-allow-origins=*");
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver(edge);
	driver.get(url);
	driver.manage().window().maximize();
}
@Test
public void testRun() {
	List<WebElement>radio_buttons=driver.findElements(By.xpath("//input[@type='radio']"));
	System.out.println("total number of radio buttons: " +radio_buttons.size());
	
	for(int i=0;i<radio_buttons.size();i++)
		radio_buttons.get(i).click();
	
	TakesScreenshots.takesScreenshot(driver, "radiobuttons");
	
	List<WebElement>checkbox=driver.findElements(By.xpath("//input[@type='checkbox']"));
	System.out.println("total number of checkboxes are : " +checkbox.size());
	
	
	for(WebElement check:checkbox)
		check.click();
	TakesScreenshots.takesScreenshot(driver, "checkboxes");
}

@AfterTest
public void close() {
	driver.close();
	
}
}
