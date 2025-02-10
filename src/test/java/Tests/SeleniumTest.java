package Tests;

import Pages.HomePage;
import Pages.ProductsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SeleniumTest {

    public static WebDriver driver;

    static ExtentTest test;                             //reporte individual por test
    static ExtentReports extent = new ExtentReports();  //reporte genereal

    @BeforeTest
    public static void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");

        ExtentSparkReporter spark = new ExtentSparkReporter("target/SparkReport.html"); //crea el reporte en la carpeta target
        extent.attachReporter(spark);

        HomePage.click_hamburguer_menu();
        HomePage.click_orderProducts_link();
    }

    @Test
    void validateTitlesFormal_OnlineProducts() throws InterruptedException {
        test = extent.createTest("Validate Formal Shoes title name on Products Page",
                "En este test se valida que el título 'Formal Shoes' sea visible para el usuario");

        try {
            ProductsPage.verifyTitle("Formal Shoes");
            test.pass("El título es correcto: 'Formal Shoes'");
        } catch (AssertionError e) {
            test.fail("El título es incorrecto. Se esperaba: 'Formal Shoes'").fail(e.getMessage());
            throw e; // Para que TestNG detecte el fallo
        }
    }

    @Test
    void validateTitlesSport_OnlineProducts() throws InterruptedException {
        test = extent.createTest("Validate Sports Shoes title name on Products Page",
                "En este test se valida que el título 'Sports Shoes' sea visible para el usuario");

        try {
            ProductsPage.verifyTitle("Sports Shoes");
            test.pass("El título es correcto: 'Sports Shoes'");
        } catch (AssertionError e) {
            test.fail("El título es incorrecto. Se esperaba: 'Sports Shoes'").fail(e.getMessage());
            throw e; // Para que TestNG detecte el fallo
        }
    }


    @Test
    void validateTitlesSneaker_OnlineProducts() throws InterruptedException, IOException {
        test = extent.createTest("Validate Sneakers Shoes title name on Products Page",
                "En este test se valida que el título 'Sneaker Shoes' sea visible para el usuario");

        try {
            ProductsPage.verifyTitle("Sneaker Shoes");
            test.pass("El título es correcto: Sneaker Shoes");
        } catch (AssertionError e) {
            Thread.sleep(1000);
            String screenshotPath = takeScreenshot(driver);
            test.fail("El título es incorrecto. Se esperaba: 'Sneaker Shoes'").addScreenCaptureFromPath(screenshotPath);
            throw e; // Para que el test falle correctamente en TestNG
        }

    }

    @Test
    void validateFirstFormalShoes(){
        test = extent.createTest("Validate First Formal Shoes name on Table 1 on Products Page",
                "En este test se valida que el título 'Sneaker Shoes' sea visible para el usuario");
        try {
            ProductsPage.formalShoes_firstShoe_verify();
            test.pass("El nombre del primer producto es correcto");
        } catch (AssertionError e){
            test.fail("El nombre del primer producto no coincide").fail(e.getMessage());
            throw e;
        }
    }

    @Test
    void validateFirstSportShoes(){
        test = extent.createTest("Validate First Sports Shoes name on Table 2 on Products Page",
                "En este test se valida que el título 'Sneaker Shoes' sea visible para el usuario");
        try {
            ProductsPage.sportShoes_firstShoe_verify();
            test.pass("El nombre del primer producto es correcto");
        } catch (AssertionError e){
            test.fail("El nombre del primer producto no coincide").fail(e.getMessage());
            throw e;
        }
    }

    @Test
    void validateFirstSneakerShoes(){
        test = extent.createTest("Validate First Sneakers Shoes name on Table 3 on Products Page",
                "En este test se valida que el título 'Sneaker Shoes' sea visible para el usuario");
        try {
            ProductsPage.sneakers_firstShoe_verify();
            test.pass("El nombre del primer producto es correcto");
        } catch (AssertionError e){
            test.fail("El nombre del primer producto no coincide").fail(e.getMessage());
            throw e;
        }
    }

    @AfterTest
    public static void tearDown() {
        driver.quit();
        extent.flush(); //guarda y finaliza el reporte
    }

    public  String takeScreenshot(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File(System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png");
        String errflpath = Dest.getAbsolutePath();
        FileUtils.copyFile(scrFile, Dest);
        return errflpath;
    }

}
