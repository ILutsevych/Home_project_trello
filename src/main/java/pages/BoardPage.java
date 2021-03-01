package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardPage extends ParentPage {
    @FindBy(xpath = ".//button[@data-test-id='header-create-menu-button']")
    private WebElement buttonCreate;
    @FindBy(xpath = ".//span[contains(text(),'Создайте доску')]")
    private WebElement buttonBoardFromTemplate;

    public BoardPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void clickOnButtonCreate(){
        clickOnElement(buttonCreate);
    }
    public void clickOnButtonCreateBoardFromTemplate(){
        clickOnElement(buttonBoardFromTemplate);
    }
}
