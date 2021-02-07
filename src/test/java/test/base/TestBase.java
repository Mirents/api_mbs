
package test.base;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestBase {
    private static WebDriver driver = null;
    private static WebDriverWait wait;
    
    @BeforeAll
    static void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-notifications");
        options.addArguments("disable-infobars");
        // Без этих опций вообще не начинало работу
        //options.addArguments("disable-popup-blocking");
        //options.addArguments("incognito");        
        
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver(options);
        
        //driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 10, 1000);

        // 1. Перейти по ссылке https://www.sberbank.ru/ru/person
        String baseUrl = "https://www.sberbank.ru/ru/person";
        driver.get(baseUrl);
        
        new WebDriverWait(driver, 1).until( 
            webDriver -> ((JavascriptExecutor) webDriver)
        .executeScript("return document.readyState").equals("complete"));
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll");
    }

    /*@BeforeEach
    void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("@AfterEach");
    }*/
    
}
