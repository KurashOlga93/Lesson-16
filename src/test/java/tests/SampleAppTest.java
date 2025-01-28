package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleAppTest {

    @Test
    public void sampleAppLoginTest() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.uitestingplayground.com/sampleapp");
        driver.findElement(By.name("UserName")).sendKeys("Olga");
        driver.findElement(By.name("Password")).sendKeys("pd");
        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();

        String expected = "Welcome, Olga!";
        String actual = driver.findElement(By.xpath("//*[@class=\"text-success\"]")).getText();
        Assert.assertEquals(actual, expected);

        driver.quit();
    }
}
