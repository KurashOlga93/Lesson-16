package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuAppTest {

    // Go to the https://the-internet.herokuapp.com/login
    // Enter "tomsmith" to username field
    // Enter "SuperSecretPassword!" to password field
    // Click "Login"

    @Test
    public void herokuLoginTest() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        String expected = "Logout";
        String actual = driver.findElement(By.xpath("//*[@class=\"button secondary radius\"]")).getText();
        Assert.assertEquals(actual, expected);

        driver.quit();
    }
}
