package pageobjects;

import cucumber.runtime.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AvvillasLibertyCreditPage {

    public AvvillasLibertyCreditPage(WebDriver myDriver) {
        this.myDriver = myDriver;
        PageFactory.initElements(myDriver, this);
    }

    private WebDriver myDriver;

    @FindBy(id = "i_monto_prestamo")
    private WebElement amount;

    @FindBy(id = "i_plazo_meses")
    private WebElement termInMonths;

    @FindBy(id = "s_destinocredito")
    WebElement creditDestination;

    @FindBy(xpath = "//button[@class=\"btn\"]")
    WebElement calculateButton;

    @FindBy(xpath = "//span[@class=\"colorTextVali selectorSpanValidacion\"]")
    WebElement titleFieldAmount;

    @FindBy(xpath = "//span[@class=\"colorTextValiB selectorSpanValidacion\" and @ng-show=\"formularioSimulador.s_convenio.$error.required\"]")
    WebElement titleFieldAgreement;

    public void changePage() {
        for (String winHandle : myDriver.getWindowHandles()) {
            myDriver.switchTo().window(winHandle);
        }
    }

    public void setAmount(String data) {
        amount.sendKeys(data);
    }

    public void setTermInMonths(String months) {
        termInMonths.clear();
        termInMonths.sendKeys(months);
    }

    public void setCreditDestination(String opcionCreditDestination) {

        WebDriverWait wait = new WebDriverWait(myDriver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(creditDestination, "Gastos Personales"));

        creditDestination.click();
        Select opt = new Select(creditDestination); // no entendí muy bien porque se debe declarar dentro del método y no por fuera
        opt.selectByVisibleText("Gastos Personales");
    }

    public void libertyCreditCalculate() {
        calculateButton.click();
    }

    public String verifyMessagesFieldAmount(){
       return titleFieldAmount.getText().toString();
    }

    public String verifyMessagesFieldAgreement(){
        return titleFieldAgreement.getText().toString();
    }
}
