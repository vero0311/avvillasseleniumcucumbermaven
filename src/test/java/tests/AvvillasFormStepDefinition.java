package tests;

import cucumber.api.java.Before;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.AvvilasHomePage;
import pageobjects.AvvillasLibertyCreditPage;
import static org.junit.Assert.assertEquals;

public class AvvillasFormStepDefinition implements En {

    private WebDriver myDriver;
    public final static String URL_AVVILLAS="https://www.avvillas.com.co";
    private AvvilasHomePage avvillashomepage;
    private AvvillasLibertyCreditPage avvillasLibertyCreditPage;

    @Before
    public void setup() {
        System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
        myDriver = new ChromeDriver();
        avvillashomepage = new AvvilasHomePage(myDriver);
        avvillasLibertyCreditPage = new AvvillasLibertyCreditPage(myDriver);
       // myDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

public AvvillasFormStepDefinition(){

    Given("That I am in Avvillas home page", () -> {
        myDriver.get(URL_AVVILLAS);
        avvillashomepage.enterToSimulator();
    });


    When("I write in amount field  {string} AND in term in month {string} AND in credit destination {string} and I do not choose any option in liberty agreement field", (String amount, String termInMonths, String creditDestination) -> {
        avvillasLibertyCreditPage.changePage();
        avvillasLibertyCreditPage.setAmount(amount);
        avvillasLibertyCreditPage.setTermInMonths(termInMonths);
        avvillasLibertyCreditPage.setCreditDestination(creditDestination);

    });


    Then("I hope to see warning messages, {string} and {string}", (String textAmountExpected, String textAgreementExpected) -> {
        avvillasLibertyCreditPage.libertyCreditCalculate();
        assertEquals(textAmountExpected,avvillasLibertyCreditPage.verifyMessagesFieldAmount());
        assertEquals(textAgreementExpected,avvillasLibertyCreditPage.verifyMessagesFieldAgreement());

    });
}

}
