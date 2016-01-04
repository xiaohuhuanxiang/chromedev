package com.demo.seleniumandroid;

import junit.framework.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;
public class demoselenium  {
//extends TestCase
	
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
		driver.get("http://m.fun.tv/");
//			WebElement element = driver.findElement(By.name("q"));
//			element.sendKeys("hello");
//			
//			element.submit();
//			
			System.out.println("title:"+driver.getTitle());//console 打印title:风行网-中国领先的新一代视频平台
		driver.quit();
	}

}
