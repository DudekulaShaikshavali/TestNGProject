package com.screenshots;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
public class TakesScreenshots {
	public static String dir=System.getProperty("user.dir");
public static void takesScreenshot(WebDriver driver,String path) {
	try{
	TakesScreenshot take=((TakesScreenshot)driver);
	File source=take.getScreenshotAs(OutputType.FILE);
	File destfile=new File(dir + "//screenshots\\" +path + ".png");
	FileUtils.copyFile(source,destfile);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}
}
