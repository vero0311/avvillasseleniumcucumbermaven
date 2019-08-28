package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AvvilasHomePage {

    public AvvilasHomePage(WebDriver myDriver){
        this.myDriver = myDriver;
        PageFactory.initElements(myDriver,this);
    }

    private WebDriver myDriver;

    @FindBy(xpath = "//a[@class=\"menu-link\" and @title=\"Simuladores\"]")
    private WebElement simulatorButton;

    @FindBy(id = "MenuSimuladorCreditoLibranza")
    private WebElement libertyCreditButton;

    public void enterToSimulator(){
        Actions action = new Actions(myDriver);
        action.moveToElement(simulatorButton).moveToElement(libertyCreditButton).click().build().perform();
    }

}
