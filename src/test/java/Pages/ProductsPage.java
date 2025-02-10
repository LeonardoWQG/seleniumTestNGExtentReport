package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static Tests.SeleniumTest.driver;

public class ProductsPage {


    public static String formalShoesDropdown_xpath = "/html/body/div[2]/center/div/i[1]";
    public static String sportShoesDropdown_xpath= "/html/body/div[3]/center/div/i[1]";
    public static String sneakerDropdown_xpath= "/html/body/div[4]/center/div/i[1]";

    public static String formalShoes_firstShoeName = "/html/body/div[2]/table/tbody/tr[1]/td[1]";
    public static String sportShoes_firstShoeName ="/html/body/div[3]/table/tbody/tr[1]/td[1]";
    public static String sneakers_firstShoeName = "/html/body/div[4]/table/tbody/tr[1]/td[1]";


    public static void verifyTitle(String expectedTitle) {
        String formattedTitle = expectedTitle.replace(" ", "");
        String actualTitle = driver.findElement(By.cssSelector("div.container h2."+ formattedTitle +"Title")).getText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    public static void formalShoes_firstShoe_verify(){
        String expectedFirstFormalShoeName = " Classic Cheltenham";
        driver.findElement(By.xpath(formalShoesDropdown_xpath)).click();
        String actualFirstFormalShoes = driver.findElement(By.xpath(formalShoes_firstShoeName)).getText();
        Assert.assertEquals(actualFirstFormalShoes.trim(), expectedFirstFormalShoeName.trim());
    }

    public static void sportShoes_firstShoe_verify(){
        String expectedFirstSportShoeName = "Ultimate";
        driver.findElement(By.xpath(sportShoesDropdown_xpath)).click();
        String actualFirstSportShoes = driver.findElement(By.xpath(sportShoes_firstShoeName)).getText();
        Assert.assertEquals(actualFirstSportShoes.trim(), expectedFirstSportShoeName.trim());
    }

    public static void sneakers_firstShoe_verify(){
        String expectedFirstSneakersShoeName = "Archivo";
        driver.findElement(By.xpath(sneakerDropdown_xpath)).click();
        String actualFirstSneakersShoes = driver.findElement(By.xpath(sneakers_firstShoeName)).getText();
        Assert.assertEquals(actualFirstSneakersShoes.trim(), expectedFirstSneakersShoeName.trim());
    }



}
