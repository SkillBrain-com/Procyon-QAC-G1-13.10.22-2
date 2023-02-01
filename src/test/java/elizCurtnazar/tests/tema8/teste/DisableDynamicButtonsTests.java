package elizCurtnazar.tests.tema8.teste;

import elizCurtnazar.tests.tema8.pageObject.DisableDynamicButtonsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisableDynamicButtonsTests extends BaseTest {

    @Test(groups = {"mobile","desktop"})
    public void runDisableDynamicButtonsPage() {
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
        DisableDynamicButtonsPage disableDynamicButtonsPage = new DisableDynamicButtonsPage(driver);
        disableDynamicButtonsPage.clickButtons();
    }
}
