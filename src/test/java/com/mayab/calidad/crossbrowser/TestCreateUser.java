package com.mayab.calidad.crossbrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.net.URL;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestCreateUser {
	
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	public static final String URL = "https://elrayodev:cd3607ae-d3d4-408b-8e8f-7450bbeec91d@ondemand.us-west-1.saucelabs.com:443/wd/hub";

	public static void main(String[] args) throws Exception{
		
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("platform", "macOS 10.13");
		caps.setCapability("version", "lastest");
		caps.setCapability("browserName", "firefox");
		caps.setCapability("name", "firefoxTest");
		caps.setCapability("extendedDebugging", "true");
		caps.setCapability("buildNumber", "3.0");
		
		/*
		DesiredCapabilities caps = DesiredCapabilities.safari();
		caps.setCapability("platform", "macOS 10.13");
		caps.setCapability("version", "11");
		caps.setCapability("name", "safari");
		caps.setCapability("extendedDebugging", "true");
		caps.setCapability("buildNumber", "3.0");
		*/
		
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		
		driver.get("https://mern-crud.herokuapp.com/");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[1]/div/input")).sendKeys("Eloy");;
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[2]/div/input")).sendKeys("eloy@gmail.com");
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[1]/div/input")).sendKeys("24");
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click();
		String result = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/p")).getText();
		
		String expected = "Successfully added!";
		assertEquals(expected, result);
		
		boolean finalResult = false;
		if(result.equals("Successfully added!")) {
			finalResult = true;
		}else {
			finalResult = false;
		}
		
		if(finalResult) {
			((JavascriptExecutor)driver).executeScript("sauce:job-result-passed");
		}else
			((JavascriptExecutor)driver).executeScript("sauce:job-result-failed");
		
		driver.quit();
			
	}
	
}
