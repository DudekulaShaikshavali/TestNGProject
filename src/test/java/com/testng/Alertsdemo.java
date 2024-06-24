package com.testng;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Alertsdemo {
	WebDriver driver;
	@Test
	public void alert() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://testautomationpractice.blogspot.com/");
	WebElement ale=driver.findElement(By.xpath("//button[text()='Alert']"));
			ale.click();
	Alert alt=driver.switchTo().alert();
	String text=alt.getText();
	System.out.println("alert message:"+text);
	alt.accept();
	
	WebElement conf=driver.findElement(By.xpath("//div/button[2]"));
	conf.click();
	Alert confirm=driver.switchTo().alert();
	String text1=confirm.getText();
	System.out.println("Confirmation message:"+text1);
	confirm.accept();
	//confirm.dismiss();
	
	WebElement prompt=driver.findElement(By.xpath("//div/button[3]"));
	prompt.click();
	Alert promp=driver.switchTo().alert();
	promp.sendKeys("Welcome To Testing");
	String text2=promp.getText();
	System.out.println("Prompt message:"+text2);
	promp.accept();
	
	
	Actions ac=new Actions(driver);
	WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
	WebElement drop=driver.findElement(By.xpath("//div[@id='droppable']"));
	ac.dragAndDrop(drag, drop);
	
	}

}
