package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.screenshots.TakesScreenshots;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDemo {
	WebDriver driver;
String utl="https://www.google.in";

@BeforeTest
public void lauch() {
	EdgeOptions edge=new EdgeOptions();
	edge.addArguments("--remote-allow-origins=*");
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver(edge);
	driver.get(utl);
	driver.manage().window().maximize();
}

@Test
public void runtest() {
	driver.findElement(By.name("q")).sendKeys("javatpoint" +Keys.ENTER);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	System.out.println(driver.getTitle());
	TakesScreenshots.takesScreenshot(driver, "google");
}

@AfterTest
public void teardown() {
	driver.close();
}
}
