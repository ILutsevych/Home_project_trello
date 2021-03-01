package loginTest;

import baseTest.BaseTest;
import org.junit.Test;

public class LoginTest extends BaseTest {
    final private String VALID_LOGIN = "trellotest681@gmail.com";
    final private String VALID_PASS = "TR2021el";
    final private String INVALID_LOGIN = "12589@gmail.com";
    final private String INVALID_PASS = "12589";

    @Test
    public void invalidLogin(){
        homePage.openHomePage();
        homePage.clickOnButtonEnter();
        loginPage.checkIsRedirectedOnLoginPage();
        loginPage.enterLoginSignIn(INVALID_LOGIN);
        loginPage.enterPasswordSignIn(INVALID_PASS);
        loginPage.clickButtonLogIn();

        checkExpectedResult("Alert Error is not visible",loginPage.isAlertErrorVisible());
        checkExpectedResult("Button Log In is visible",loginPage.buttonLogInIsVisible());
    }
    @Test
    public void validLogin(){
        homePage.openHomePage();
        homePage.clickOnButtonEnter();
        loginPage.fillLoginFormAndSubmit(VALID_LOGIN, VALID_PASS);
        homePage.userProfileButtonIsVisible();
        homePage.logOutAndExit();

        checkExpectedResult("Text is not visible",loggedOutPage.isTextThatApprovedLogOutVisible());
        checkExpectedResult("Log out button is not visible",loggedOutPage.logInButtonIsVisible());




    }
}
