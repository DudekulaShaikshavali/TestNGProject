package com.testng;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	WebDriver driver;
	String url="http://www.deadlinkcity.com/";
	int brokenlinks;
	
	@BeforeSuite
	public void launch() {
		EdgeOptions edge=new EdgeOptions();
		edge.addArguments("--remote-allow-origins=*");
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver(edge);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	
	@Test
	public void runtest() throws IOException {
		driver.get(url);
		driver.manage().window().maximize();
		List<WebElement>links=driver.findElements(By.tagName("a"));
		System.out.println("total number of links: " +links.size());
		
		brokenlinks=0;
		for(WebElement link:links) {
			String hrefatt=link.getAttribute("href");
//			System.out.println(targetlink);
			if(hrefatt==null || hrefatt.isEmpty()) {
				System.out.println("href attribute value is empty: " );
				continue;
			}
			
			URL linkurl=new URL(hrefatt); //convert string --> url format
			HttpURLConnection conn=(HttpURLConnection)linkurl.openConnection();//send request to server - open, connect
			conn.connect();
			
			if(conn.getResponseCode() >=400) {
				System.out.println(hrefatt+ " "+"===> Broken Link");
				brokenlinks ++;
			}else {
				System.out.println(hrefatt+ " "+"===> Not Broken Link");
			}
		}
		
		System.out.println("total number of broken links: " +	brokenlinks);
		
	}
	
	@AfterSuite
	public void teardown() {
		driver.close();
	}

}
