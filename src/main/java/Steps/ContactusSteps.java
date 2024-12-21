package Steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactusSteps {
    static WebDriver driver;
    static WebDriverWait wait;
    @BeforeAll
    public static void initialsetUp() {
        //driver = new ChromeDriver();



        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        System.out.println(System.getProperty(("user.dir")));
        System.out.println("Before All------------------->");
    }
    @Before
    public void setUp(){
    System.out.println("Before------------------->");
    }



    @Given("I open url")
    public void i_open_url() {
        driver.get ("https://www.naukri.com/");
        System.out.println("I open url------------------->");
    }
    @Given("User navigates to the Naukri login page")
    public void user_navigates_to_naukri_login_page() throws InterruptedException {
        // Set up WebDriver
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait with 10 seconds timeout
        driver.get("https://www.naukri.com/nlogin/login");
        Thread.sleep(2000);
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        // Wait for the username field to be visible
//        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder*='Enter your active Email ID / Username']"))); // replace with actual id
//        WebElement passwordField = driver.findElement(By.xpath('//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[3]/input')); // replace with actual id
//        driver.findElement(By.xpath("//*[@id=\"login_Layer\"]")).click();
//        usernameField.sendKeys("seshusamireddy@gmail.com"); // replace with actual username
//        passwordField.sendKeys("Seshu@112"); // replace with actual password
//
//        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[6]/button")); // replace with actual id
//        loginButton.click();


        System.out.println("Opening Nakuri ----------------------------------->");
        driver.findElement(By.cssSelector("a[id$='login_Layer']")).click();
        // driver.find_element_by_css_selector("input[placeholder=$'Enter your active Email ID / Username']").sendKeys("seshusamireddy@gmail.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            Thread.sleep(5000);  // Hard wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder*='Enter your active Email ID / Username']"))); // replace with actual id
//        usernameField.sendKeys("seshusamireddy@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder=$'Enter your active Email ID / Username']")).sendKeys("seshusamireddy@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[3]/input")).sendKeys("Seshu@112");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[6]/button")).click();

    }

    @When("User logs in successfully")
    public void user_logs_in_successfully() {
        // Wait for the profile page to load (you can use any element that is unique to the profile page)
        WebElement profilePageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profilePageId"))); // replace with actual element id
    }

    @Then("User should be redirected to the profile page")
    public void user_should_be_redirected_to_profile_page() {
        // Check if the profile page is loaded
        //  assertTrue(driver.getCurrentUrl().contains("profile"));
    }

    @When("User updates the profile summary")
    public void user_updates_the_profile_summary() {
        // Wait for the profile summary field to be visible
        WebElement summaryField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profileSummaryId"))); // replace with actual id
        summaryField.clear();
        summaryField.sendKeys("This is the updated profile summary.");

        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("saveButtonId"))); // replace with actual id
        saveButton.click();
    }

    @Then("User should see the updated profile summary")
    public void user_should_see_updated_profile_summary() {
        // Wait for the updated summary to be visible on the profile
        WebElement updatedSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profileSummaryId"))); // replace with actual id
        if(updatedSummary.getText().contains("This is the updated profile summary.")){
            System.out.println("---------------------Done");
        }
        // assertTrue(updatedSummary.getText().contains("This is the updated profile summary."));
        driver.quit();
    }




    @When("I enter firstname")
    public void i_enter_firstname() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I enter firstname------------------->");
    }
    @And("I enter email")
    public void i_enter_email() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I enter firstname------------------->");
    }
    @And("I enter Comment")
    public void i_enter_comment() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I enter firstname------------------->");
    }
    @And("submit")
    public void submit() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I enter firstname------------------->");
    }
    @Then("I should the sucess message")
    public void i_should_the_sucess_message() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I enter firstname------------------->");
        //driver.quit();
    }
    @AfterAll
    public static void tearDown() {
        // Quit the driver after all tests are finished
        if (driver != null) {
            driver.quit();
        }
    }

}
