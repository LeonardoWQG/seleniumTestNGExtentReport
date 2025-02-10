package Pages;

import org.openqa.selenium.By;

import static Tests.SeleniumTest.driver;

public class HomePage {

    public static String hambur_menu = "//*[@id=\"menuToggle\"]/input";
    public static String onlineProducts ="//*[@id=\"menu\"]/a[3]/li";

    public static void click_hamburguer_menu(){
        driver.findElement(By.xpath(hambur_menu)).click();
    }

    public static void click_orderProducts_link() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(onlineProducts)).click();
    }
}
