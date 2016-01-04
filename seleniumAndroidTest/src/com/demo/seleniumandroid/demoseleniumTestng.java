package com.demo.seleniumandroid;

import junit.framework.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class demoseleniumTestng  {
	WebDriver driver ;

	@BeforeTest
	public void setUp() {
		// 启动手机端的webdriver——作为服务端，没有其他前台应用
		try {
			//打开webdriver
			// 配置adb 环境变量http://jingyan.baidu.com/article/17bd8e52f514d985ab2bb800.html
Runtime.getRuntime().exec( "adb shell am start -a android.intent.action.MAIN " +	"-n org.openqa.selenium.android.app/.MainActivity");
/*连接服务端webdriver，连接用的端口为8080，如果本地有开启了或使用了该端口，需要关闭（http://localhost:8080/exit），不然连接不上服务端webdriver   */
 Runtime.getRuntime().exec("adb -s HC51BWWE0103 forward tcp:8080 tcp:8080");
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = new AndroidDriver();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test  
    public void testBaidu() {        
		driver.get("http://m.baidu.com/");
		System.out.println("title:"+driver.getTitle());//title:百度一下
			WebElement element = driver.findElement(By.name("word"));
			element.sendKeys("hello");
			
			element.submit();
			
			System.out.println("title:"+driver.getTitle());//title:hello - 百度
   }  


}
