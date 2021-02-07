package test;

import org.junit.jupiter.api.*;
import pages.DebetCard;
import pages.HomePage;
import pages.YouthCard;
import test.base.BaseTest;

@DisplayName("A special test case")
public class ScenarioTest extends BaseTest {
    
    @Test
    public void MyTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        DebetCard debetCard = new DebetCard(driver);
        YouthCard youthCard = new YouthCard(driver);

        homePage.clickButtonMenu();
        homePage.clickButtonPodMenu();
        debetCard.checkLabelPage();
        debetCard.checkAndClickCards();
        youthCard.checkLabelPage();
        //youthCard.clickButtonIssueOnline();
        youthCard.fillInputs();
        youthCard.clickButtonNext();
        youthCard.checkInput();
    }
}
