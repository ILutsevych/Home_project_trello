package loginTest;

import baseTest.BaseTest;
import org.junit.Test;

public class LoginTest extends BaseTest {
    private String validLogin = "trellotest681@gmail.com";
    private String validPass = "TR2021el";
    private String inValidLogin = "12589@gmail.com";
    final private String INVALID_PASS = "12589";

    @Test
    public void invalidLogin(){
        homePage.openHomePage();
        homePage.clickOnButtonEnter();
        loginPage.fillLoginFormAndSubmit(inValidLogin, INVALID_PASS);

        checkExpectedResult("Alert Error is not visible",loginPage.isAlertErrorVisible());
        checkExpectedResult("Button Log In is visible",loginPage.buttonLogInIsVisible());
    }
}
