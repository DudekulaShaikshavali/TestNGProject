package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.screenshots.TakesScreenshots;

public class DragAndDrop {
	WebDriver driver;
	@Test
	public void draganadrop() {
		driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)","");
	Actions ac=new Actions(driver);
	WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
	WebElement drop=driver.findElement(By.xpath("//div[@id='droppable']"));
	ac.dragAndDrop(drag, drop).build().perform();
	TakesScreenshots.takesScreenshot(driver, "drag and drop");
	

}
}
