package tests.day19_CrossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C02_NegativLoginTesti extends TestBaseCross {

    @Test
    public void negativTest(){
        //mycoursedemy anasayfaya gidin
        driver.get(ConfigReader.getProperty("myUrl"));
        //login butonuna basin
       WebElement loginLinki= driver.findElement(By.xpath("//a[text()='Log in']"));
       loginLinki.click();
        //email ve password icin gecersiz degerler girin
       WebElement emailKutusu =driver.findElement(By.xpath("//input[@id='login-email']"));
                emailKutusu.sendKeys(ConfigReader.getProperty("myYanlisEmail"));

        driver.findElement(By.xpath("//input[@id='login-password']"))
                .sendKeys(ConfigReader.getProperty("myYanlisPassword"));
        //login butonuna basin
       WebElement loginButonu= driver.findElement(By.xpath( "//*[text()='Log in']"));
       loginButonu.click();
        //giris yapilamadigini test edin
        ReusableMethods.wait(3);
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Log in']")).isDisplayed());
        ReusableMethods.wait(5);

    }
}
