package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    private WebDriver myDriver;
    private WebDriverWait myWait;
    private Select selection;

    public PageBase(WebDriver myDriver){
        this.myDriver = myDriver;
        PageFactory.initElements(myDriver,this);
        myWait = new WebDriverWait(myDriver,10);
    }

    public WebDriver getWebDriver(){
        return myDriver;
    }

    public void changePage() {
        for (String winHandle : myDriver.getWindowHandles()) {
            myDriver.switchTo().window(winHandle);
        }
    }

    public void hover(WebElement externalElement, WebElement internalElement){
        Actions action = new Actions(myDriver);
        action.moveToElement(externalElement).moveToElement(internalElement).click().build().perform();
    }

    public WebDriverWait getWait(){
        return myWait;
    }

    public void selectElement(WebElement element, String textToSelect){
        Select selection = new Select(element);
        selection.selectByVisibleText(textToSelect);
    }






}
