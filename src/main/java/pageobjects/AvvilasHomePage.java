package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AvvilasHomePage extends PageBase {

    public AvvilasHomePage(WebDriver myDriver) {
        super(myDriver);
    }

    @FindBy(xpath = "//a[@class=\"menu-link\" and @title=\"Simuladores\"]")
    private WebElement simulatorButton;

    @FindBy(id = "MenuSimuladorCreditoLibranza")
    private WebElement libertyCreditButton;

    public void enterToSimulator() {
        super.hover(simulatorButton,libertyCreditButton);
    }
}
