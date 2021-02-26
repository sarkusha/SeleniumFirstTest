import org.junit.Assert;
import org.junit.Test;

import javax.sql.rowset.serial.SQLOutputImpl;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {

@Test
    public void CheckUrL() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    By namberPhone = By.xpath("//input[@data-qa-node='phone-number']");

   driver.get("https://next.privat24.ua/mobile");

   driver.findElement(namberPhone).sendKeys("982815857");

   driver.findElement(By.xpath(".//input [@data-qa-node='amount']")).sendKeys("10");
   driver.findElement(By.xpath(".//input [@data-qa-node='numberdebitSource']")).sendKeys("5309233034765085");
   driver.findElement(By.xpath(".//input [@data-qa-node='expiredebitSource']")).sendKeys("0124");
   driver.findElement(By.xpath(".//input [@data-qa-node='cvvdebitSource']")).sendKeys("891");
    Thread.sleep(2000);
   driver.findElement(By.xpath(".//button [contains(text(), 'В кошик')]")).click();

    By amount = By.xpath(".//span[@data-qa-node='amount']");
    By payerCard = By.xpath(".//td[@data-qa-node='card']");
    By details = By.xpath(".//span[@data-qa-node='details']");
    By commission = By.xpath(".//span[@data-qa-node='commission']");
    By commissionCurrency = By.xpath(".//small[@data-qa-node='commission-currency']");



    Assert.assertEquals("10", driver.findElement(amount).getText());
    Assert.assertEquals("5309 **** **** 5085", driver.findElement(payerCard).getText());
    Assert.assertEquals("Поповнення телефону. На номер +380982815857", driver.findElement(details).getText());
    Assert.assertEquals("2", driver.findElement(commission).getText());
    Assert.assertEquals(" UAH", driver.findElement(commissionCurrency).getText());

    driver.findElement(By.xpath(".//button[contains(text(), 'Підтвердити')]")).click();
    


    }
}
