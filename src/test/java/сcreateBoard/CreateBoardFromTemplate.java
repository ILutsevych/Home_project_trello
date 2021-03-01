package сcreateBoard;

import baseTest.BaseTest;
import org.junit.Test;

public class CreateBoardFromTemplate extends BaseTest {
        final private String VALID_LOGIN = "trellotest681@gmail.com";
        final private String VALID_PASS = "TR2021el";
        final private String BOARD_NAME = "DreamBoard for template";

        @Test
        public void createBoardFromTemplate() {
            homePage.openHomePage();
            homePage.clickOnButtonEnter();
            loginPage.fillLoginFormAndSubmit(VALID_LOGIN, VALID_PASS);
            homePage.userProfileButtonIsVisible();
            boardPage.clickOnButtonCreate();
            boardPage.clickOnButtonCreateBoardFromTemplate();
            teamPage.fillHeaderOfBoard(BOARD_NAME);
            teamPage.clickOnButtonCreateBoard();
            checkExpectedResult("Board name is not valid",teamPage.isBoardNameVisible());
            teamPage.deleteBoard();
            checkExpectedResult("Text'Board is not found' is not visible",teamPage.boardIaNotFoundVisible());
            homePage.logOutAndExit();
        }

}
