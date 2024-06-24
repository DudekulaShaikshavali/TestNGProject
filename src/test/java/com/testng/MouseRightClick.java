package com.testng;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.screenshots.TakesScreenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseRightClick {
	WebDriver driver;
	String url="https://swisnl.github.io/jQuery-contextMenu/demo.html";
	
	@BeforeClass
	public void launch() {
		EdgeOptions edge=new EdgeOptions();
	edge.addArguments("--remote-allow-origins=*");
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver(edge);
	driver.manage().window().maximize();
	
	}
	
@Test	
public void rightclick() {
	driver.get(url);
	WebElement button=driver.findElement(By.xpath("//span[text()='right click me']"));
	Actions ac=new Actions(driver);
	ac.contextClick(button).build().perform();
	WebElement el=driver.findElement(By.xpath("//html/body/ul/li[3]"));//.click();
	ac.moveToElement(el).click().build().perform();
	System.out.println(driver.switchTo().alert().getText());
	driver.switchTo().alert().accept();
	TakesScreenshots.takesScreenshot(driver, "alertmessage");
	}


@AfterClass
public void teardown() {
	driver.close();
}
}
