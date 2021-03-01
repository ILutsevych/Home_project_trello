package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TeamPage extends ParentPage {

    @FindBy(xpath = ".//a [@data-test-id='header-home-button']")
    private WebElement homeIcon;
    @FindBy(xpath = ".//span[contains(text(),'DreamTeam') and @data-test-id='home-team-tab-name']")
    private WebElement newTeam;
    @FindBy(xpath = ".//*[contains(text(),'Настройки')]")
    private WebElement settingsMenu;
    @FindBy(xpath = ".//*[contains(text(),'Создать доску')]")
    private WebElement newBoard;
    @FindBy(xpath = ".//input[@data-test-id='create-board-title-input']")
    private WebElement boardHeader;
    @FindBy(xpath = ".//button[@data-test-id='create-board-submit-button']")
    private WebElement buttonCreateBoard;
    @FindBy(xpath = ".//span[ contains(text(),'Меню')]")
    private WebElement menuButton;
    @FindBy(xpath = ".//*[contains(text(),'Ещё')]")
    private WebElement buttonMore;
    @FindBy(xpath = ".//a[ contains(text(),'Закрыть доску')] ")
    private WebElement buttonCloseBoard;
    @FindBy(xpath = ".//input[@type='submit' and @value = 'Закрыть']")
    private WebElement closeBoardButtonOnPopUp;
    @FindBy(xpath = ".//a[contains(text(), 'Безвозвратное удаление доски…')]")
    private WebElement foreverBoardDeletionButton;
    @FindBy(xpath = ".//input[@value='Удалить']")
    private WebElement buttonDeleteBoard;

    public TeamPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isTeamNameIsVisible() {
        try{
            return webDriverWait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h1 [contains(text(),'DreamTeam')]"))).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    public void clickOnHomeIcon(){
        clickOnElement(homeIcon);
        logger.info("Icon home is clicked");
    }
    public void clickOnNewTeam(){
        clickOnElement(newTeam);
        logger.info("New team was clicked");
    }
    public void clickOnMenuSettings(){
        clickOnElement(settingsMenu);
        logger.info("Clicked button Settings");
    }
    public void clickOnButtonCreateNewBoard(){
        clickOnElement(newBoard);
        logger.info("Button New Board is clicked");
    }
    public void fillHeaderOfBoard(String header){
        enterTextIntoElement(boardHeader,header);
        logger.info("Title was inputed");
    }
    public void clickOnButtonCreateBoard(){
        clickOnElement(buttonCreateBoard);
        logger.info("Button create Board was clicked");
    }
    public boolean isBoardNameVisible() {
        try{
            return webDriverWait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h1[contains(text(),'DreamBoard')]"))).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    public void clickOnMenu(){
        clickOnElement(menuButton);
        logger.info("Button Menu was clicked");
    }
    public void clickOnButtonMore(){
        clickOnElement(buttonMore);
        logger.info("Button More was clicked");
    }
    public void clickOnButtonCloseTheBoard(){
        clickOnElement(buttonCloseBoard);
    }
    public void clickCloseBoardButtonOnPopUP(){
        clickOnElement(closeBoardButtonOnPopUp);
    }
    public void clickOnButtonForeverBoardDeletion(){
        clickOnElement(foreverBoardDeletionButton);
    }
    public void clickOnButtonDeleteTheBoard(){
        clickOnElement(buttonDeleteBoard);
    }
    public void deleteBoard(){
        clickOnMenu();
        clickOnButtonMore();
        clickOnButtonCloseTheBoard();
        clickCloseBoardButtonOnPopUP();
        clickOnButtonForeverBoardDeletion();
        clickOnButtonDeleteTheBoard();
    }
    public boolean boardIaNotFoundVisible() {
        try{
            return webDriverWait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h1[contains(text(),'Доска не найдена.')]"))).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
