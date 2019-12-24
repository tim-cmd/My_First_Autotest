package mixcloud.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlayAllSteps {
    @Managed WebDriver driver;


    @Test


    @Given("^User navigates to mixcloud website$")
    public void user_navigates_to_mixcloud_website() {
        driver.get("https://www.mixcloud.com/");
        this.driver.manage().window().maximize();
    }

    @Step
    @When("^User clicks on the login button on homepage$")
    public void user_clicks_on_the_login_button_on_homepage() {
        driver.findElement(By.xpath("//span[contains(text(), 'Log in')]")).click();
    }

    @Step
    @When("^User enters a valid username \"([^\"]*)\"$")
    public void user_enters_a_valid_username(String username) {
        driver.findElement(By.xpath("//*[@id=\"react-root\"]//div/form/div[1]//input")).sendKeys(username);


    }
    @Step
    @When("^User enters a valid password \"([^\"]*)\"$")
    public void user_enters_a_valid(String password) {
        driver.findElement(By.xpath("//*[@id=\"react-root\"]//div/form/div[2]//input")).sendKeys(password);

    }
    @Step
    @When("^User clicks on the login button$")
    public void user_clicks_on_the_login_button() {
        driver.findElement(By.xpath("//span[contains(text(), 'Log In')]")).submit();

    }
    @Step
    @Then("^User should be logged in$")
    public void user_should_be_logged_in() throws Throwable {
        Thread.sleep(5000);
        WebElement Petya=driver.findElement(By.xpath("//span[contains(text(), 'ByShadow')]"));
        Assert.assertTrue(Petya.isDisplayed());
    }
    @Step
    @Then("^User clicks Search field$")
    public void user_clicks_Search_field() throws Throwable {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div/input['mixcloud_query']")).click();
    }
    @Step
    @When("^User enters artistname in the Search field$")
    public void user_enters_artistname_in_the_Search_field() {
        driver.findElement(By.xpath("//div/input['mixcloud_query']")).sendKeys("Martin Garrix");
    }
    @Step
    @Then("^User opens the artists page$")
    public void user_opens_the_artists_page() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/section/div[4]/div/div/div[1]/div/div/section/div[1]/div[2]/div[2]/section/div/ul/li[1]/span/b/span[1]/a")).click();
    }
    @Step
    @When("^User plays all available tracks$")
    public void user_plays_all_available_tracks() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(), 'Play all')]")).click();
    }
    @Step
    @When("^User add artists to favorite$")
    public void user_add_artists_to_favorite() {
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/section/div[5]/div/div/div[1]/div[4]/span")).click();
    }
    @Step
    @Then("^User opens his own profile$")
    public void user_opens_his_own_profile() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/section/div[4]/div/div/header/div/div[3]/div[1]/div/span")).click();
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/section/div[4]/div/div/header/div/div[3]/div[1]/span/div/div/ul/li[1]/a")).click();
    }

    @Step
    @When("^Artist should be in favorites$")
    public void artist_should_be_in_favorites() throws Throwable {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(), 'Favorites')]")).click();
        Thread.sleep(2000);
        WebElement Follow=driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/section/div[4]/div/div/div/div/div[4]/main/div[1]/div/div/section/hgroup/h2/span[1]/a"));
        Assert.assertTrue(Follow.isDisplayed());

    }

    @Step
    @Then("^User deletes favorites$")
    public void user_deletes_favorites() {
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/section/div[4]/div/div/div/div/div[4]/main/div[1]/div/div/section/span")).click();
    }
}
