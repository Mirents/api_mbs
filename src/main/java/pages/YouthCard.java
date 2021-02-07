package pages;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YouthCard {
    WebDriver driver;
    WebDriverWait wait;
    
    @FindBy(xpath = "//h1[contains(@class, 'kitt-heading  page-teaser-"
            + "dict__header kitt-heading_size_l')]")
    WebElement labelPage;
    
    @FindBy(xpath = "//span[contains(@class, 'kitt-button__text')]")
    WebElement buttonIssueOnline;
    
    @FindBy(xpath = "//input[contains(@data-name, 'lastName')]")
    WebElement inputFieldLastName;
    
    @FindBy(xpath = "//input[contains(@data-name, 'firstName')]")
    WebElement inputFieldFirstName;
    
    @FindBy(xpath = "//input[contains(@data-name, 'middleName')]")
    WebElement inputFieldMiddleName;
    
    @FindBy(xpath = "//input[contains(@data-name, 'cardName')]")
    WebElement inputFieldCardName;

    @FindBy(xpath = "//input[contains(@data-name, 'birthDate')]")
    WebElement inputFieldBirthDate;
    
    @FindBy(xpath = "//input[contains(@data-name, 'email')]")
    WebElement inputFieldEmail;
    
    @FindBy(xpath = "//input[contains(@data-name, 'phone')]")
    WebElement inputFieldPhone;
    
    @FindBy(xpath = "//button[contains(@class, 'odcui-button odcui-button_color_black')]")
    WebElement buttonNext;
    
    @FindBy(xpath = "//input[contains(@data-name, 'series')]//..//div[contains(@class, 'odcui-error__text')]")
    WebElement inputSeries;
    
    @FindBy(xpath = "//input[contains(@data-name, 'number')]//..//div[contains(@class, 'odcui-error__text')]")
    WebElement inputNumber;
    
    @FindBy(xpath = "//input[contains(@data-name, 'issuedate')]//..//div[contains(@class, 'odcui-error__text')]")
    WebElement inputIssueDate;
    
    public YouthCard(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 1000);
    }

    public void checkLabelPage() {
        Assertions.assertEquals(labelPage.getText(), "Молодёжная карта");
    }

    public void clickButtonIssueOnline() {
        buttonIssueOnline.click();
    }

    public void fillInputs() {

        wait.until(ExpectedConditions.visibilityOf(inputFieldLastName));
        inputFieldLastName.sendKeys("Антонов");
        Assertions.assertEquals(inputFieldLastName.getAttribute("value"), "Антонов");
        
        inputFieldFirstName.sendKeys("Михаил");
        Assertions.assertEquals(inputFieldFirstName.getAttribute("value"), "Михаил");
        
        inputFieldMiddleName.sendKeys("Иванович");
        Assertions.assertEquals(inputFieldMiddleName.getAttribute("value"), "Иванович");
        
        inputFieldCardName.clear();
        inputFieldCardName.sendKeys("MIHAIL ANTONOV");
        Assertions.assertEquals(inputFieldCardName.getAttribute("value"), "MIHAIL ANTONOV");
        
        inputFieldBirthDate.sendKeys("22.02.2004");
        Assertions.assertEquals(inputFieldBirthDate.getAttribute("value"), "22.02.2004");
        
        inputFieldEmail.sendKeys("antmih@mail.ru");
        Assertions.assertEquals(inputFieldEmail.getAttribute("value"), "antmih@mail.ru");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {}
        
        Actions actions = new Actions(driver);
        actions.click(inputFieldPhone);
        actions.perform();
        
        inputFieldPhone.sendKeys("9681278345");
        Assertions.assertEquals(inputFieldPhone.getAttribute("value"), "+7 (968) 127-83-45");
    }
    
    public void clickButtonNext() {
        Actions actions = new Actions(driver);
        try {
            actions.moveToElement(buttonNext);
            actions.perform();
        } catch (Exception ex) {}
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {}
        
        buttonNext.click();
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {}
    }
    
    public void checkInput() {
        System.out.println("------->" + inputSeries.getText());
        Assertions.assertEquals(inputSeries.getText(), "Обязательное поле");
        Assertions.assertEquals(inputNumber.getText(), "Обязательное поле");
        Assertions.assertEquals(inputIssueDate.getText(), "Обязательное поле");
    }
}
