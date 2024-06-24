package com.testng;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOver {
	WebDriver driver;
	String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	@BeforeClass
	public void launch() {
		EdgeOptions edge=new EdgeOptions();
		edge.addArguments("--remote-allow-origins=*");
		WebDriverManager.edgedriver().setup();
       driver=new EdgeDriver(edge);
		driver.manage().window().maximize();
	}
	@Test
	public void mouseover() {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement user=driver.findElement(By.xpath("//input[@placeholder='Username']"));
		WebElement pass=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		WebElement click=driver.findElement(By.xpath("//button[@type='submit']"));
		user.sendKeys(" Admin");
		pass.sendKeys("admin123");
		click.click();
//		Actions ac=new Actions(driver);
//		ac.moveToElement(user).build().perform();
//		ac.moveToElement(pass).build().perform();
//		ac.moveToElement(click).click().build().perform();
		
		
	
		
	}

}
