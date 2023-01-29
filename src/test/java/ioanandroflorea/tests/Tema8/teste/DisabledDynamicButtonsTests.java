package ioanandroflorea.tests.Tema8.teste;

import ioanandroflorea.tests.Tema8.pageObjects.DisabledDynamicButtonsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DisabledDynamicButtonsTests extends BaseTest {

    @Test(groups = {"mobile", "desktop"})
    public void dynamicButtonsTests() {
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
        DisabledDynamicButtonsPage disabledDynamicButtonsPage = new DisabledDynamicButtonsPage(driver);
        disabledDynamicButtonsPage.waitForTheStartButtonToBeClickable();
        disabledDynamicButtonsPage.clickOnStartButton();
        disabledDynamicButtonsPage.waitForOneButtonToBeClickable();
        disabledDynamicButtonsPage.clickOnOneButton();
        disabledDynamicButtonsPage.waitForTheMessageToDisappear();
        disabledDynamicButtonsPage.clickOnSecondButton();
        disabledDynamicButtonsPage.waitForTheMessageToDisappear();
        disabledDynamicButtonsPage.clickOnThirdButton();
        if (disabledDynamicButtonsPage.waitForConfirmationMessageToAppear()) {
            System.out.println("All buttons were clicked");
        }
    }
}
