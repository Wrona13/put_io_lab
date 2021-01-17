package put.bdd;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import put.selenium.pageobjects.repository.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class RegisterStepsDefinition {
    private WebDriver driver;

    private ResetDatabase resetDatabse;
    private MainMenu mainMenu;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private MainPage mainPage;
    private LoggedInUserInformation loggedInUserInfo;
    private AccountsListPage accountsListPage;

    private String hostURL;

    public RegisterStepsDefinition() throws IOException {
        Properties properties = new Properties();
        InputStream in = getClass().getResourceAsStream("bdd.properties");
        properties.load(in);
        in.close();

        this.hostURL=properties.getProperty("host.url");
        this.hostURL = "http://localhost:8080";

        System.setProperty("webdriver.chrome.driver", "chromedriver-mac");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        resetDatabse = new ResetDatabase(driver, this.hostURL);
        mainMenu = new MainMenu(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver, this.hostURL);
        accountsListPage = new AccountsListPage(driver);
        loggedInUserInfo = new LoggedInUserInformation(driver);

        resetDatabse.resetDatabase();
    }
    @Given("^I've moved to the register page$")
    public void I_am_on() throws Throwable {
        mainPage.openPage();
        mainMenu.clickLoginLink();
        mainMenu.clickRegisterLink();
        assertTrue(registrationPage.isOnPage());
    }

    @When("^I fill the registration form with username \"([^\"]*)\", password \"([^\"]*)\" and \"([^\"]*)\", name \"([^\"]*)\" and adress\"([^\"]*)\", and I submit it$")
    public void I_fill_in_with(String username, String password, String rep_password, String name, String adress) throws Throwable {
        registrationPage.registerUser(username, password,rep_password,name,adress);

    }

    @Then("^I should see the login page$")
    public void I_should_see_accunts_list_page() throws Throwable {
        assertTrue(loginPage.isOnPage());
    }


    @After
    public void closeBrowser(){
        driver.close();
    }
}
