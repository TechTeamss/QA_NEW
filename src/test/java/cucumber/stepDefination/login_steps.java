package cucumber.stepDefination;

/*
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import static org.testng.Assert.assertTrue;

@Test
public class login_steps {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("I am on the SauceDemo login page")
    public void iAmOnSauceDemoLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I log in with username {string} and password {string}")
    public void iLogInWithUsernameAndPassword(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @Then("I should see the products page if login is successful")
    public void iShouldSeeProductsPage() {

        assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Login failed!");

    }

    @Then("I should verify login success or failure")
    public void iShouldVerifyLoginSuccessOrFailure() {
        WebElement errorElement = driver.findElement(By.cssSelector("h3[data-test='error']"));
        assertTrue(errorElement.isDisplayed(), "Login successful with incorrect credentials!");
    }

    // Close the browser after all scenarios are executed
    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
*/


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

@Test
public class login_steps {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginWithValidUsernames() {
        String[] validUsernames = {"standard_user", "locked_out_user"};
        for (String username : validUsernames) {
            loginWithUsernameAndPassword(username, "secret_sauce");
            verifySuccessfulLogin();
        }
    }

    @Test
    public void testLoginWithInvalidUsernames() {
        String[] invalidUsernames = {"invalid_user", "problem_user"};
        for (String username : invalidUsernames) {
            loginWithUsernameAndPassword(username, "invalid_password");
            verifyFailedLogin();
        }
    }

    private void loginWithUsernameAndPassword(String username, String password) {
        driver.get("https://www.saucedemo.com/");
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='LOGIN']"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    private void verifySuccessfulLogin() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed for valid user");
    }

    private void verifyFailedLogin() {
        String expectedUrl = "https://www.saucedemo.com/";
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html",
                "Login was successful for invalid user");
    }


    @DataProvider (name="credential")
    public Object [] [] getData(){
        return new Object[][] {
                {"valid","standard_user","secret_sauce"},
                {"invalid","cbfr@1","cbfr@3"},
                {"invalidUN","cbfr@2","secret_sauce"},
                {"invalidPWD","standard_user","cbfr@5"},
                {"blank","",""}
        };
    }
    @Test(dataProvider = "credential")
    public void verifyLoginFunctionality(String scenerio , String username , String password) throws IOException{
        login.enterCredentials(username,password);
        if(scenerio=="valid"){
            String actResult=login.verifyURL();
            String expResult=utilityclass.readPFData()
        }
    }
}