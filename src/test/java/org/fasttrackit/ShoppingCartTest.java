package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingCartTest {

    @Test
    public void addToCartFromSearchResultsTest() {
        System.setProperty("webdriver.chrome.driver","D:\\madisonIslandTests\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");

        String keyWord = "vase";
        driver.findElement(By.id("search")).
                sendKeys(keyWord);

        driver.findElement(By.tagName("button")).click();

        String productToCart ="Herald Glass Vase";
        driver.findElement(By.xpath(
                "//div[@class='product-info' and .//a[text()='"+productToCart+"']]//button[@title='Add to Cart']")).click();

        String cart = driver.findElement(By.className("success-msg")).getText();

        assertThat("Unexpected success message", cart, is(productToCart + " was added to your shopping cart."));

        WebElement productNameInCart = driver.findElement(By.xpath("//table[@id='shopping-cart-table']//a[text()='" + productToCart + "']"));

        assertThat("Product not displayed in cart.", productNameInCart.isDisplayed());

    }
}
