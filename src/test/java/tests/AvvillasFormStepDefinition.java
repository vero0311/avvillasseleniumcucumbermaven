package tests;

import cucumber.api.java.Before;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.AvvilasHomePage;
import pageobjects.AvvillasLibertyCreditPage;
import java.util.concurrent.TimeUnit;
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
        myDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

public AvvillasFormStepDefinition(){

    Given("That I am in Avvillas home page", () -> {
        myDriver.get(URL_AVVILLAS);
        avvillashomepage.enterToSimulator();
    });


    When("I write in amount field  {string} AND in term in month {string} AND in credit destination {string} and I do not choose any option in liberty agreement field", (String string, String string2, String string3) -> {
        avvillasLibertyCreditPage.changePage();
        avvillasLibertyCreditPage.setAmount(string);
        avvillasLibertyCreditPage.setTermInMonths(string2);
        avvillasLibertyCreditPage.setCreditDestination(string3);

    });


    Then("I hope to see warning messages, {string} and {string}", (String string, String string2) -> {
        avvillasLibertyCreditPage.libertyCreditCalculate();
        assertEquals(string,avvillasLibertyCreditPage.verifyMessagesFieldAmount());
        assertEquals(string2,avvillasLibertyCreditPage.verifyMessagesFieldAgreement());

    });
}

}
