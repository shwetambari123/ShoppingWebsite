import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yogesh on 12-09-2016.
 */
public class StepDefn {
    WebDriver driver;

    public void isTextPresentAt(By element, String text) {
        String textboxvalue = driver.findElement(element).getText();
        Assert.assertTrue(textboxvalue.contains(text));// Assert.assertTrue(driver.findElement(element).getText().contains(text));
    }


    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver","src/main/browser");
        driver = new ChromeDriver();
        driver.get("http://sbtechnos11.trial52.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("^Admin is on login page$")
    public void adminOnLogin() {
        Assert.assertTrue(driver.findElement(By.id("btnLogin")).isDisplayed());
    }

    @When("^Admin enters username as\"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void adminEnterDetail(String username, String password) {
        driver.findElement(By.cssSelector("#txtUsername")).sendKeys(username);
        driver.findElement(By.cssSelector("#divPassword")).sendKeys(password);
    }
    @When("^Andmin select login$")
    public void andminselectlogin() {
        driver.findElement(By.cssSelector("#btnLogin")).click();
    }
    @Then("^Admin should see welcome message as \"([^\"]*)\"$")
    public void adminLoggedIn(String message) throws Throwable {
        isTextPresentAt(By.id("welcome"), message);

    }

}
