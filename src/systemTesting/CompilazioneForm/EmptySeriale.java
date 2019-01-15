package systemTesting.CompilazioneForm;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EmptySeriale {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEmptySeriale() throws Exception {
    driver.get("http://localhost:8080/EnglishValidation/index.jsp");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("x.x@studenti.unisa.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("password");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Login'])[3]/following::button[1]")).click();
    driver.get("http://localhost:8080/EnglishValidation/_areaStudent/firstForm.jsp");
    driver.findElement(By.id("immatricolazione")).click();
    new Select(driver.findElement(By.id("immatricolazione"))).selectByVisibleText("2015/2016");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Richiesta'])[1]/following::option[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Disconnetti'])[2]/following::div[11]")).click();
    driver.findElement(By.id("ente")).click();
    new Select(driver.findElement(By.id("ente"))).selectByVisibleText("Educational Testing Service (ETS)");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ente di rilascio:'])[1]/following::option[4]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Disconnetti'])[2]/following::div[11]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CFU da Conseguire:'])[1]/following::button[1]")).click();
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