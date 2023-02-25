package catalinazoldi.tests.Tema8.tests;


import catalinazoldi.tests.Tema8.pageObjects.BasicAjaxPage;
import org.testng.annotations.Test;

public class BasicAjaxTest extends BaseTest {

    @Test(groups = "Desktop")
    public void codeItInTestForDesktop() {
        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
        BasicAjaxPage basicAjaxPage = new BasicAjaxPage(driver);
        System.out.println("Code It In test Desktop");
        System.out.println("Got to 'Basic Ajax Example' link");
        basicAjaxPage.selectCategory(1);
        System.out.println("Select category");
        basicAjaxPage.selectLanguage(2);
        System.out.println("Select language");
        basicAjaxPage.clickOnButton();
    }

    @Test(groups = "Mobile")
    public void codeItInTestForMobile() {
        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
        BasicAjaxPage basicAjaxPage = new BasicAjaxPage(driver);
        System.out.println("Code It In test Mobile");
        System.out.println("Got to 'Basic Ajax Example' link");
        basicAjaxPage.selectCategory(1);
        System.out.println("Select category");
        basicAjaxPage.selectLanguage(2);
        System.out.println("Select language");
        basicAjaxPage.clickOnButton();
    }
}
