package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//a[@href = '/login']")
    private WebElement enterButton;
    @FindBy(xpath = ".//button [@ data-test-id='header-member-menu-button']")
    private WebElement userProfileButton;
    @FindBy(xpath = ".//button [@data-test-id='header-member-menu-logout']")
    private WebElement exitButton;
    @FindBy(xpath = ".//button[@ id='logout-submit']")
    private WebElement exitAtlassianButton;
    @FindBy(xpath = ".//button[@data-test-id='home-navigation-create-team-button']")
    private WebElement createTeamButton;
    @FindBy(xpath = ".//input[@data-test-id='header-create-team-name-input']")
    private WebElement inputname;
    @FindBy(xpath = ".//div[contains(text(),'Инженерия/ИТ')]")
    private WebElement teamTypeEngineering;
    @FindBy(xpath = ".//*[contains(text(),'Выбрать')]")
    private WebElement teamSelect;
    @FindBy(xpath = ".//button[@type = 'submit']")
    private WebElement continueButton;
    @FindBy(xpath = ".//a[@data-test-id='show-later-button']")
    private WebElement doThisLaterButton;
    @FindBy(xpath = "//button[@aria-label='Закрыть' and contains(@class,'2b_HpRl1Tyl1YK')]")
    private WebElement exitButtonFromForm;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    public void openHomePage(){
        try {
            webDriver.get("https://trello.com/home");
            logger.info("Home Page was opened");
        }catch(Exception e){
            logger.error("Can not open Home page");
            Assert.fail("Can not open Home page");
        }
    }
    public void clickOnButtonEnter(){
        clickOnElement(enterButton);
    }

    public boolean userProfileButtonIsVisible(){
        try{
            return webDriverWait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button [@ data-test-id='header-member-menu-button']"))).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    public void clickOnUserProfileButton(){
        clickOnElement(userProfileButton);
    }
    public boolean userEmailIsVisibleInProfile(){
        try{
            return webDriverWait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(text(),'trellotest681@gmail.com')]"))).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    public void clickOnExitButton(){
        clickOnElement(exitButton);
        logger.info("Exit button is clicked");
    }

    public void exitFromAtlassianAccount(){
        clickOnElement(exitAtlassianButton);
        logger.info("Exit from Atlassian button is clicked");
    }
    public void clickOnCreateTeamButton(){
        clickOnElement(createTeamButton);
        logger.info("Create team button is clicked");
    }
    public void enterCommandName(String commandName){
        enterTextIntoElement(inputname,commandName);
        logger.info("Team name is entered");
    }
    public void clickOnTeamTypeEngineering(){
         clickOnElement(teamSelect);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        teamTypeEngineering.click();
        logger.info("Type Engineering is clicked");
    }
    public void clickOnContinueButton(){
        clickOnElement(continueButton);
        logger.info("Continue button is clicked");
    }
    public void clickOnDoThisLatterButton(){
        clickOnElement(doThisLaterButton);
        logger.info("Do this later button is clicked");
    }
    public void logOutAndExit(){
        clickOnUserProfileButton();
        userEmailIsVisibleInProfile();
        clickOnExitButton();
        exitFromAtlassianAccount();
    }
    public boolean continueButtonIsDisabled(){
        try{
            logger.info("Continue button is disable");
            return !webDriver.findElement(By.xpath(".//button[@type = 'submit']")).isEnabled();

        }catch (Exception e){
            return false;
        }

    }
    public void clickOnExitButtonFromForm(){
        clickOnElement(exitButtonFromForm);
        logger.info("Exit from Form.");
    }
    public boolean textCreateATeamIsVisible(){
        try{
            return webDriverWait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(text(), 'Создайте команду')]"))).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }



}
