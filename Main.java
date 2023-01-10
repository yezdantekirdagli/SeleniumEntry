import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class Main {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup(); //reach to Chrome
        WebDriver driver = new ChromeDriver(); // driver identification

        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        WebElement FullName = driver.findElement(By.cssSelector("#userName")); //identify element
        FullName.click(); //click element
        FullName.sendKeys("Yezdan Tekirdağlı"); //send information to element

        WebElement eMail = driver.findElement(By.xpath("//input[@id='userEmail']"));

        eMail.click();
        eMail.sendKeys("yezdan.tekirdagli@gmail.com");

        WebElement currentAddress = driver.findElement(By.cssSelector("#currentAddress"));
        currentAddress.click();
        currentAddress.sendKeys("Istanbul, Turkey");

        JavascriptExecutor js = (JavascriptExecutor) driver; //selenium scroll down
        js.executeScript("window.scrollBy(0,250)");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.click();
        permanentAddress.sendKeys("Atasehir, Istanbul, Turkey");

        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        submitButton.click();

        js.executeScript("window.scrollBy(0,250)");

        driver.quit(); // quit chrome


    }
}
