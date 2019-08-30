package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AvvillasLibertyCreditPage extends PageBase {

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

    public AvvillasLibertyCreditPage(WebDriver myDriver) {
        super(myDriver);
    }

    public void setAmount(String data) {
       super.getWait().until(ExpectedConditions.visibilityOf(amount));
        amount.sendKeys(data);

    }

    public void setTermInMonths(String months) {
        termInMonths.clear();
        termInMonths.sendKeys(months);
    }

    public void setCreditDestination(String opcionCreditDestination) {

        super.getWait().until(ExpectedConditions.textToBePresentInElement(creditDestination, "Gastos Personales"));
        creditDestination.click();
        super.selectElement(creditDestination,"Gastos Personales");
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
