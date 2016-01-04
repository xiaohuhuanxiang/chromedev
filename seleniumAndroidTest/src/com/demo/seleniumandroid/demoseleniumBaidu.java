package com.demo.seleniumandroid;

import junit.framework.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.Test;


public class demoseleniumBaidu  {

	
	public static void main(String[] args) {
	
		try {
			//打开webdriver
			Runtime.getRuntime().exec("adb shell am start -a android.intent.action.MAIN "
					+ "-n org.openqa.selenium.android.app/.MainActivity");
			/*连接服务端webdriver，连接用的端口为8080，如果本地有开启了或使用了该端口，需要关闭（http://localhost:8080/exit），不然连接不上服务端webdriver   */
			Runtime.getRuntime().exec("adb -s HC51BWWE0103 forward tcp:8080 tcp:8080");
		} catch (Exception e) {
			// TODO: handle exception
		}
		WebDriver driver = new AndroidDriver();
		driver.get("http://m.baidu.com/");
		System.out.println("title:"+driver.getTitle());//title:百度一下
			WebElement element = driver.findElement(By.name("word"));
			element.sendKeys("hello");
			
			element.submit();
			
			System.out.println("title:"+driver.getTitle());//title:hello - 百度
		driver.quit();
	}

}
