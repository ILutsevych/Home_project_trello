package createTeam;

import baseTest.BaseTest;
import org.junit.Test;

public class CreateTeam extends BaseTest {
    final private String VALID_LOGIN = "trellotest681@gmail.com";
    final private String VALID_PASS = "TR2021el";
    final private String COMMAND_NAME = "DreamTeam";

    @Test
    public void createTeam(){
        homePage.openHomePage();
        homePage.clickOnButtonEnter();
        loginPage.fillLoginFormAndSubmit(VALID_LOGIN, VALID_PASS);
        homePage.userProfileButtonIsVisible();
        homePage.clickOnCreateTeamButton();
        homePage.enterCommandName(COMMAND_NAME);
        homePage.clickOnTeamTypeEngineering();
        homePage.clickOnContinueButton();
        homePage.clickOnDoThisLatterButton();

        checkExpectedResult("Team name is not visible",teamPage.isTeamNameIsVisible());

        teamPage.clickOnHomeIcon();
        teamPage.clickOnNewTeam();
        teamPage.clickOnMenuSettings();
        teamAccount.clickOnDeleteButton();
        teamAccount.clickOnDeleteForever();

        homePage.logOutAndExit();



    }

}

