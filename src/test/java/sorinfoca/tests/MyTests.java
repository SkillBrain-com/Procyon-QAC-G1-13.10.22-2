package sorinfoca.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sorinfoca.driver.BrowserManager;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MyTests extends TestConfig {

    WebDriver driver;

    @DataProvider(name = "formDetails")
    public Object[][] fullDetails(){
        return new Object[][]{
                {"Foca Sorin", "sorinfoca@test.com", 1},
                {"Sorin", "sorinf@test.com", 2},
                {"Foca Sorin", "sorinfoca@test.com", 1},
                {"Sorin", "sorinf@test.com", 2},
                {"Foca Sorin", "sorinfpca@test.com", 1},
                {"Sorin", "sorinf@test.com", 2}
        };
    }

    @Test(dataProvider = "formDetails")
    public void test2(String name, String email, int index) {
        System.out.println(name +" " + email + " " + index);
    }

    @Test
    public void test1() {
        driver = BrowserManager.createChromeDriver();
        testValidLogin();
        testInvalidLogin();
        testRedirectToLogin();
        testPositiveBookingScenario();
        testNegativeBookingScenario();
        testHomeButton();
        driver.quit();
    }

    public void testValidLogin() {
        driver.get(getBaseUrl());
        driver.findElement(By.cssSelector("#menu-toggle")).click();
        driver.findElement(By.cssSelector("#sidebar-wrapper > ul > li:nth-child(4) > a")).click();
        driver.findElement(By.cssSelector("#txt-username")).sendKeys("John Doe");
        driver.findElement(By.name("password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        assertEquals("https://katalon-demo-cura.herokuapp.com/#appointment",driver.getCurrentUrl());
        logOut();
    }

    public void testInvalidLogin() {
        driver.get(getBaseUrl());
        driver.findElement(By.cssSelector("#menu-toggle")).click();
        driver.findElement(By.cssSelector("#sidebar-wrapper > ul > li:nth-child(4) > a")).click();
        driver.findElement(By.name("password")).sendKeys("invalid_password");
        driver.findElement(By.id("txt-username")).sendKeys("invalid_username");
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        assertTrue(driver.findElement(By.cssSelector("#login > div > div > div.col-sm-12.text-center > p.lead.text-danger")).isDisplayed());
    }

    public void testRedirectToLogin() {
        driver.get(getBaseUrl());
        driver.findElement(By.cssSelector("#btn-make-appointment")).click();
        assertEquals("https://katalon-demo-cura.herokuapp.com/profile.php#login",driver.getCurrentUrl());
    }

    public void testPositiveBookingScenario() {
        driver.get(getBaseUrl());
        driver.findElement(By.cssSelector("#menu-toggle")).click();
        driver.findElement(By.cssSelector("#sidebar-wrapper > ul > li:nth-child(4) > a")).click();
        driver.findElement(By.cssSelector("#txt-username")).sendKeys("John Doe");
        driver.findElement(By.name("password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        driver.findElement(By.cssSelector("#chk_hospotal_readmission")).click();
        driver.findElement(By.cssSelector("#radio_program_medicaid")).click();
        driver.findElement(By.cssSelector("#txt_visit_date")).sendKeys("10/10/23");
        driver.findElement(By.cssSelector("#txt_comment")).sendKeys("Commentariu test");
        driver.findElement(By.xpath("//*[@id=\"btn-book-appointment\"]")).click();
        assertTrue(driver.findElement(By.cssSelector("#summary > div > div > div.col-xs-12.text-center > h2")).isDisplayed());
        logOut();
    }

    public void testNegativeBookingScenario() {
        driver.get(getBaseUrl());
        driver.findElement(By.cssSelector("#menu-toggle")).click();
        driver.findElement(By.cssSelector("#sidebar-wrapper > ul > li:nth-child(4) > a")).click();
        driver.findElement(By.cssSelector("#txt-username")).sendKeys("John Doe");
        driver.findElement(By.name("password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        driver.findElement(By.cssSelector("#radio_program_medicaid")).click();
        driver.findElement(By.cssSelector("#txt_comment")).sendKeys("Commentariu test negativ");
        driver.findElement(By.xpath("//button[text()='Book Appointment']")).click();
        assertTrue(driver.findElement(By.cssSelector("#txt_visit_date")).isDisplayed());
    }

    public void testHomeButton() {
        driver.get(getBaseUrl());
        driver.findElement(By.cssSelector("#menu-toggle")).click();
        driver.findElement(By.cssSelector("#sidebar-wrapper > ul > li:nth-child(3) > a")).click();
        assertEquals(getBaseUrl() , driver.getCurrentUrl());
    }

    public void logOut() {
        driver.findElement(By.cssSelector("#menu-toggle")).click();
        driver.findElement(By.cssSelector("#sidebar-wrapper > ul > li:nth-child(6) > a")).click();
    }
}
