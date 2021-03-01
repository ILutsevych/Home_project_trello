package сcreateBoard;

import baseTest.BaseTest;
import org.junit.Test;

public class CreateBoard extends BaseTest {
    final private String VALID_LOGIN = "trellotest681@gmail.com";
    final private String VALID_PASS = "TR2021el";
    final private String BOARD_NAME = "DreamBoard";

    @Test
    public void createBoard(){
        homePage.openHomePage();
        homePage.clickOnButtonEnter();
        loginPage.fillLoginFormAndSubmit(VALID_LOGIN, VALID_PASS);
        homePage.userProfileButtonIsVisible();
        teamPage.clickOnButtonCreateNewBoard();
        teamPage.fillHeaderOfBoard(BOARD_NAME);
        teamPage.clickOnButtonCreateBoard();
        checkExpectedResult("Board name is not valid",teamPage.isBoardNameVisible());
        teamPage.deleteBoard();
        checkExpectedResult("Text'Board is not found' is not visible",teamPage.boardIaNotFoundVisible());
        homePage.logOutAndExit();

    }
}
