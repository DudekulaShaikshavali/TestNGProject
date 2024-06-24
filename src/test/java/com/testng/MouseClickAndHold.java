package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.screenshots.TakesScreenshots;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseClickAndHold {
WebDriver driver;
String url="http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html";

@BeforeClass
public void launch() {
	EdgeOptions edge=new EdgeOptions();
	edge.addArguments("--remote-allow-origins=*");
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver(edge);
	driver.manage().window().maximize();
}

@Test
public void clickandhold() {
	driver.get(url);
	driver.manage().deleteAllCookies();
	WebElement source=driver.findElement(By.id("box1"));
	WebElement target=driver.findElement(By.id("box103"));
	Actions ac=new Actions(driver);
	//ac.clickAndHold(source).moveToElement(target).release().build().perform();
	ac.dragAndDrop(source, target).build().perform();
	TakesScreenshots.takesScreenshot(driver, "osco");
	
}

@AfterClass
public void teardown() {
	driver.close();
}
}
