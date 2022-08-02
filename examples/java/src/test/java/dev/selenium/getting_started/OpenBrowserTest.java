package dev.selenium.getting_started;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.nio.file.Path;
import java.time.Duration;
import java.util.Optional;

public class OpenBrowserTest {
    public WebDriver driver;

    @Test
    public void chromeSession_contactUs() throws InterruptedException {
        driver = new ChromeDriver();

        driver.get(" https://www.tech.gov.sg/");

        String title = driver.getTitle();
        Assertions.assertEquals("Government Technology Agency", title);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        System.out.println("Chrome - Getting Contact Us Details");
        WebElement searchButton = driver.findElement(By.cssSelector("#navbarExampleTransparentExample > div.navbar-start > li > a"));
        searchButton.click();
        Thread.sleep(5000);
        String verifyUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.tech.gov.sg/contact-us/", verifyUrl);
        driver.quit();
    }

    @Test
    public void chromeSession_searchEngine() throws InterruptedException {
        driver = new ChromeDriver();

        driver.get(" https://www.tech.gov.sg/");

        String title = driver.getTitle();
        Assertions.assertEquals("Government Technology Agency", title);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        System.out.println("Chrome - Search Engineer Searching Salary");
        WebElement searchButton = driver.findElement(By.id("search-activate"));
        searchButton.click();
        Thread.sleep(5000);
        WebElement searchSalary = driver.findElement(By.cssSelector("#search-bar > div > div > form > div > div:nth-child(2) > button"));
        WebElement searchBox = driver.findElement(By.id("search-box"));
        searchBox.sendKeys("Salary");
        Thread.sleep(5000);
        searchSalary.click();

        String verifyUrl1 = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.tech.gov.sg/search/?query=Salary", verifyUrl1);
        Thread.sleep(8000);
        driver.quit();
    }


    @Test
    public void edgeSession_searchEngine() throws InterruptedException {
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);
        driver.get(" https://www.tech.gov.sg/");

        String title = driver.getTitle();
        Assertions.assertEquals("Government Technology Agency", title);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        System.out.println("Edge - Search Engineer Searching Salary");
        WebElement searchButton = driver.findElement(By.id("search-activate"));
        searchButton.click();
        Thread.sleep(5000);
        WebElement searchSalary = driver.findElement(By.cssSelector("#search-bar > div > div > form > div > div:nth-child(2) > button"));
        WebElement searchBox = driver.findElement(By.id("search-box"));
        searchBox.sendKeys("Salary");
        Thread.sleep(5000);
        searchSalary.click();

        String verifyUrl1 = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.tech.gov.sg/search/?query=Salary", verifyUrl1);
        Thread.sleep(8000);
        driver.quit();
    }

    @Test
    public void edgeSession_contactUs() throws InterruptedException {
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);
        driver.get(" https://www.tech.gov.sg/");

        String title = driver.getTitle();
        Assertions.assertEquals("Government Technology Agency", title);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        System.out.println("Edge - Getting Contact Us Details");
        WebElement searchButton = driver.findElement(By.cssSelector("#navbarExampleTransparentExample > div.navbar-start > li > a"));
        searchButton.click();
        Thread.sleep(5000);
        String verifyUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.tech.gov.sg/contact-us/", verifyUrl);
        driver.quit();
    }
}
