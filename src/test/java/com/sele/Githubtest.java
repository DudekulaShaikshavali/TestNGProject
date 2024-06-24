package com.sele;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Githubtest {
	@Test
	public void test1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://github.com/");
		driver.manage().window().maximize();
		WebElement ele=driver.findElement(By.xpath("//li[3]/button[@type='button']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(ele).click().build().perform();
		
		
		WebElement redme=driver.findElement(By.xpath("//div[text()='The ReadME Project']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click(true);", redme);
		String actualTitle=driver.getTitle();
		System.out.println("actual title is:"+actualTitle);
		String expected="GitHub: Let’s build from here · GitHub";
		System.out.println("expected title is:"+expected);
		
		Assert.assertEquals(actualTitle,expected, "title is doesnot matched");
		
	TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(".//screenshots\\githublink.png");
		try {
			//FileUtils.copyFile(source, new File(".//screenshots\\github.png"));
			FileUtils.copyFile(source, target);
		}catch(Exception e) {
			e.printStackTrace();
		}
		driver.quit();
		
		
		
	}

}
