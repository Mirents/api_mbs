package pages;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    
    @FindBy(xpath = "//button[contains(@class, 'kitt-cookie-warning__close')]")
    WebElement buttonSkipCookie;
    
    @FindBy(xpath = "//a[contains(@aria-label, 'Карты')]")
    WebElement buttonMenu;
    
    @FindBy(xpath = "//a[contains(@class, 'kitt-top-menu__link kitt-top-menu__link_second') and contains(text(), 'Дебетовые')]")
    WebElement buttonPodPenu;
    
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 1000);
        
        // Нажатие на кнопку согласия с cookie, без этого у меня дальнейшие
        // действия не выполняются
        try {
            buttonSkipCookie.click();
        } catch(NoSuchElementException e) {}
    }
    
    public void clickButtonMenu() {
        buttonMenu.click();
    }
    
    public void clickButtonPodMenu() {
        wait.until(ExpectedConditions.visibilityOf(buttonPodPenu));
        buttonPodPenu.click();
    }
}
