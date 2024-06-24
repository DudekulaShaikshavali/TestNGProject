package com.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshot {
WebDriver driver;
String url="https://demo.nopcommerce.com/";
@BeforeTest
public void launch() {
	EdgeOptions edge=new EdgeOptions();
	edge.addArguments("--remote-allow-origins=*");
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver(edge);
}

@Test
public void runTest() throws IOException {
	driver.get(url);
	driver.manage().window().maximize();
	//capture full page screenshot 3 & 4
	TakesScreenshot tc=(TakesScreenshot)driver;
	/*File src=tc.getScreenshotAs(OutputType.FILE);
	File trg=new File("C:\\Users\\shaik\\eclipse-workspace\\TestNGProject\\screenshots\\full.png");
	try {
		FileUtils.copyFile(src, trg);
	}catch(IOException e) {
		e.printStackTrace();
	}
	*/
	
	//capture screenshot of specific webpage
	
	WebElement featureproduct=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
	File src=featureproduct.getScreenshotAs(OutputType.FILE);
	File trg=new File("C:\\\\Users\\\\shaik\\\\eclipse-workspace\\\\TestNGProject\\\\screenshots\\\\product.png");
	FileUtils.copyFile(src, trg);
	
	//capture screenshot of specific webelement
//	WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
//	File src=logo.getScreenshotAs(OutputType.FILE);
//	File trg=new File("C:\\Users\\shaik\\eclipse-workspace\\TestNGProject\\screenshots\\logo.png");
//	FileUtils.copyFile(src, trg);
}

@AfterTest
public void teardown() {
	driver.close();
}
}
