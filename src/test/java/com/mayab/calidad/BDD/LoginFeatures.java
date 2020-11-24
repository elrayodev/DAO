package com.mayab.calidad.BDD;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LoginFeatures {
	
	WebDriver driver;
	
	@Given("browser is open")
	public void browser_is_open() {

		System.out.println("Step - browser is open");
		
		//Obtenemos path de projecto
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is: " + projectPath);
		
		//Configuramos el webdriver
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Driver/chromedriver.exe");
				
		//Abrimos navegador
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	
	}

	@And("user is in login page")
	public void user_is_in_login_page() {
	
		System.out.println("Step - user is in login page");
		
		driver.get("https://example.testproject.io/web/");
		
	}

	//PARA PRUEBAS PARAMETRIZADAS
	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {

		System.out.println("Step - user enters username and password");
		
		driver.findElement(By.id("name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
	}
	
	/*
	 * PARA PRUEBAS NO PARAMETRIZADAS
	@When("user enters username and password")
	public void user_enters_username_and_password() {

		System.out.println("Step - user enters username and password");
		
		driver.findElement(By.id("name")).sendKeys("Eloy Jimenez");
		driver.findElement(By.id("password")).sendKeys("12345");
		
	}
	*/
	
	@When("user enters username and wrong password")
	public void user_enters_username_and_wrong_password() {

		System.out.println("Step - user enters username and wrong password");
		
		driver.findElement(By.id("name")).sendKeys("Eloy Jimenez");
		driver.findElement(By.id("password")).sendKeys("1234");
		
	}
	
	@When("user clicks login button")
	public void user_clicks_login_button() {

		System.out.println("Step - user clicks login button");
		
		driver.findElement(By.id("login")).click();
	
	}

	/*
	 * PARA NO PARAMETRIZADAS
	@Then("website shows main page")
	public void website_shows_main_page() {
		
		System.out.println("Step - user enters username and password");
		
		String result = driver.findElement(By.xpath("//*[@id=\"greetings\"]/b")).getText();

		assertEquals("Eloy Jimenez", result);
		
		driver.close();
		driver.quit();
	}
	*/
	
	@Then("website shows main page")
	public void website_shows_main_page() {
		
		System.out.println("Step - user enters username and password");
		
		String result = driver.findElement(By.id("logout")).getText();

		assertEquals("Logout", result);
		
		driver.close();
		driver.quit();
	}
	
	@Then("password is invalid error")
	public void password_is_invalid_error() {
	    
		System.out.println("Step - password is invalid error");
		
		String result = driver.findElement(By.xpath("//*[@id=\"pageLogin\"]/form/div[2]/div/div[2]")).getText();
		
		assertEquals("Password is invalid", result);
		
		driver.close();
		driver.quit();
		
	}


}
