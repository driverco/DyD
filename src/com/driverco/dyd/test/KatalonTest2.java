package com.driverco.dyd.test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class KatalonTest2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\DyD\\WEB-INF\\lib\\chromedriver.exe");
	  ChromeOptions capabilities = new ChromeOptions();
	  capabilities.setCapability("marionette", true);
	  capabilities.setCapability("binary", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
	  driver = new ChromeDriver();
	  baseUrl = "http://localhost:8080/DyD/";
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
  }

  @Test
  public void testOpenApp() throws Exception {
    driver.get("http://localhost:8080/DyD/");
    driver.findElement(By.id("buttonStart")).click();
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
