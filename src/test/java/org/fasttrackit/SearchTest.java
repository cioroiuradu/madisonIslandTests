package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {


    @Test
    public void searchByOneKeywordTest() {
        System.setProperty("webdriver.chrome.driver","D:\\madisonIslandTests\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");

        String keyWord = "vase";
        driver.findElement(By.id("search")).
                sendKeys(keyWord);
        System.out.println("Pressed enter in search field."); // log example


        driver.findElement(By.tagName("button")).click();

//        driver.findElement(By.linkText("WOMEN")).click();

        List<WebElement> productNameContainers =
                driver.findElements(By.cssSelector(".product-name > a"));

        for(WebElement container : productNameContainers) {
            String productName = container.getText();

            assertThat("Some of the produc names do not contain the searched keyword",
                    productName, containsString(keyWord.toUpperCase()));
        }

    }
}
