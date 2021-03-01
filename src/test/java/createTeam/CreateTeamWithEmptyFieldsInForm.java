package createTeam;

import baseTest.BaseTest;
import org.junit.Test;

public class CreateTeamWithEmptyFieldsInForm extends BaseTest {
    final private String VALID_LOGIN = "trellotest681@gmail.com";
    final private String VALID_PASS = "TR2021el";

    @Test
    public void createTeamWithEmptyFieldsInForm(){
        homePage.openHomePage();
        homePage.clickOnButtonEnter();
        loginPage.fillLoginFormAndSubmit(VALID_LOGIN, VALID_PASS);
        homePage.userProfileButtonIsVisible();
        homePage.clickOnCreateTeamButton();

        checkExpectedResult("Text 'Create a team' is not visible",homePage.textCreateATeamIsVisible());
        checkExpectedResult("Button is active",homePage.continueButtonIsDisabled());
        homePage.clickOnExitButtonFromForm();
        homePage.logOutAndExit();

    }
}
