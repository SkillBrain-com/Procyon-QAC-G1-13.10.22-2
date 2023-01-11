package sorinfoca.Tests.Tema6;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import sorinfoca.driver.BrowserManager;
import sorinfoca.utils.FileUtils;
import java.io.IOException;


public class HerokuAlerts {

    static ChromeDriver driver = null;

    public static void main(String[] args) throws IOException {
        navigateToHerokuHomePage();
        openAlertsPage();

        try {
            openAlert();
            acceptAlert();
            dismissAlert();
            getTextOfAlert();
            inputTextInAlert();
            handleDifferentTypeOfAlert();
        } catch (NoAlertPresentException e) {
            FileUtils.takeScreenshot(driver, "alert");
            System.out.println("No alert present");
        } finally {
            closeBrowser();
        }
    }

    public static void navigateToHerokuHomePage() {
        driver = BrowserManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        System.out.println("Opened Heroku index page");
    }

    public static void openAlertsPage() {
        WebElement alertsLink = driver.findElement(By.id("alerttest"));
        alertsLink.click();
        System.out.println("Navigated to alerts page");
    }

    public static void openAlert() {
        WebElement secondAlertButton = driver.findElement(By.xpath("//input[@id='confirmexample']"));
        secondAlertButton.click();
        System.out.println("Clicked on SecondAlertButton");
    }

    public static void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println("Accepted alert");
    }

    public static void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        System.out.println("Dismissed alert");
    }

    public static void getTextOfAlert() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
    }

    public static void inputTextInAlert() {
        Alert secondAlert = driver.switchTo().alert();
        secondAlert.sendKeys("text to input in prompt box");
        System.out.println("Entered text in alert box");
    }

    public static void handleDifferentTypeOfAlert() {
        Alert secondAlert = driver.switchTo().alert();
        String alertText = secondAlert.getText();
        if (alertText.equals("I am a confirm alert")) {
            secondAlert.accept();
            System.out.println("Accepted confirm alert");
        } else if (alertText.equals("I am a prompt alert")) {
            secondAlert.sendKeys("text to input in prompt box");
            secondAlert.accept();
            System.out.println("Accepted prompt alert and entered text");
        } else {
            System.out.println("Unknown type of alert: " + alertText);
        }
    }
        public static void closeBrowser() {
            driver.quit();
            System.out.println("Am inchis browserul");
        }
    }



