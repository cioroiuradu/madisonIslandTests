package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChangeColour {


    @Test
    public void selectProductColor() {
        System.setProperty("webdriver.chrome.driver","D:\\madisonIslandTests\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        String keyWord = "vase";
        driver.findElement(By.id("search")).
                sendKeys(keyWord);
        System.out.println("Pressed enter in search field."); // log example
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.xpath("//div[@class='category-products']//img[@alt='black']")).click();


        String buttonColor = driver.findElement(By.xpath("//div[@class='category-products']//li[@class='option-black is-media selected']")).getAttribute("class");
        System.out.println(buttonColor);

        assertThat("The color has not been changed",buttonColor,is("option-black is-media selected"));

        String pickImage = driver.findElement(By.xpath("//div[@class='category-products']//img[@class='product-collection-image-437']")).getAttribute("src");
        System.out.println(pickImage);

        String imageLink = "https://fasttrackit.org/selenium-test/media/catalog/product/cache/1/small_image/210x/602f0fa2c1f0d1ba5e241f914e856ff9/h/d/hdd002_1.jpg";

        assertThat("The picture has not been changed",pickImage,is(imageLink));

    }
}
