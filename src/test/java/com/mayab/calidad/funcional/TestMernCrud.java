package com.mayab.calidad.funcional;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestMernCrud {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\polo_\\Downloads\\chromedriver.exe");
	  driver = new ChromeDriver();
	  baseUrl = "https://mern-crud.herokuapp.com/";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCaseAllGood() throws Exception {
	  //Ingresamos a URL
	  driver.get("https://mern-crud.herokuapp.com/");

	  //Agregamos usuario
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button")).click();
	  driver.findElement(By.name("name")).sendKeys("Eloy jimenez");
	  driver.findElement(By.name("email")).sendKeys("jimenez@gmail.com");
	  driver.findElement(By.name("age")).sendKeys("24");
	  driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click();
    
	  Thread.sleep(2000);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	  //Texto esperado
	  String expectedText = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/p")).getText();
		
	  assertEquals("Successfully added!", expectedText);
  }
  
  @Test
  public void testCaseInvalidMail() throws Exception {
	  //Ingresamos a URL
	  driver.get("https://mern-crud.herokuapp.com/");

	  //Agregamos usuario con mail invalido
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button")).click();
	  driver.findElement(By.name("name")).sendKeys("Eloy Jimenez");
	  driver.findElement(By.name("email")).sendKeys("jimenez@gmail");
	  driver.findElement(By.name("age")).sendKeys("24");
	  driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click();

	  Thread.sleep(2000);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	  //Texto esperado
	  String expectedText = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[5]/div/p")).getText();

	  assertEquals("Email must be valid.", expectedText);
  }
  
  @Test
  public void testCaseDeleteUser() throws Exception {
	  //
	  driver.get("https://mern-crud.herokuapp.com/");
    
	  /*
	  //Agregamos un usuario
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button")).click();
	  driver.findElement(By.name("name")).sendKeys("Juan Hernandez");
	  driver.findElement(By.name("email")).sendKeys("hernandez@gmail.com");
	  driver.findElement(By.name("age")).sendKeys("24");
	  driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click();
	  */
	 	  
	  //Guardamos height de body despues de agregar usuario
	  int heightBefore = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/table/tbody")).getSize().getHeight();
	  System.out.println(heightBefore);
    
	  //Eliminamos usuario
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/table/tbody/tr/td[5]/button[2]")).click();
	  driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[1]")).click();
	  int heightAfter = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/table/tbody")).getSize().getHeight();
	  System.out.println(heightAfter);

    
	  Thread.sleep(2000);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
	  assertTrue(heightBefore<heightAfter);

  }
  
  @Test
  public void testCaseRepetedUser() throws Exception {
	  driver.get("https://mern-crud.herokuapp.com/");
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button")).click();
	  driver.findElement(By.name("name")).sendKeys("Eloy Jimenez");
	  driver.findElement(By.name("email")).sendKeys("jimenez@gmail.com");
	  driver.findElement(By.name("age")).sendKeys("24");
	  driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click();
	  String expectedText = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[5]/div/p")).getText();
	  
	  Thread.sleep(2000);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
	  assertEquals("That email is already taken.", expectedText);
    
  }


  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
