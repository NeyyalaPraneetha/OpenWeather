package StepImplementation;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Stepdefs {
    WebDriver driver;
    int i;

    @Given("^the home page of opens Weather map is displayed$")
    public void thehomepageofopensWeathermapisdiplayed() {
        driver = utilities.driverfactory.Open("Chrome");
        driver.get("http://openweathermap.org/forecast5");
        System.out.println("User is on the Weather report page");
        driver.manage().window().maximize();
    }


    @When("^the user searches with (.*)$")
    public void theUserSearchesWith(String CityName) throws Throwable {
        driver.findElement(By.name("q")).sendKeys(CityName);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @And("^the user click on cityname on the page (.*)$")
    public void theUserClickOnGivenCity_name(String cityname) throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//table[@class='table']/tbody/tr/td[2]/b/a")).click();
    }

    @Then("^the Weather forcaste is displayed for the (.*) on the page$")
    public void theWeatherForcasteIsDsplayedWithAllDaysOnThePage(String Cityname) {
        driver.findElement(By.className("stick-footer-panel__link")).click();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[1]/div/span[@class='chevron-container']")).click();
        String date = driver.findElement(By.xpath("//li[1][@class='active']")).getText();
        String temperature = driver.findElement(By.xpath("//*[@class='top-section']/div")).getText();
        System.out.println("Temperature in " + Cityname + " on " + date + " is: " + temperature);

    }

    @Then("^the error message \"([^\"]*)\"$")
    public void theErrorMessage(String Errormessage) throws Throwable {
        String Actualmesg = driver.findElement(By.xpath("/html/body/main/div[5]/div/div/h3")).getText();
        System.out.println("actual message is " + Actualmesg);
        Assert.assertTrue(Errormessage.contains(Actualmesg));
        driver.quit();
    }


    @Then("^the Weather forcaste is displayed for all \"([^\"]*)\" days on the page$")
    public void theWeatherForcasteIsDisplayedForAllDaysOnThePage(int Count) throws Throwable {
        driver.findElement(By.className("stick-footer-panel__link")).click();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        for (i = 1; i <= Count; i++) {
            driver.findElement(By.xpath("//li[" + i + "]/div/span[@class='chevron-container']")).click();
            String date = driver.findElement(By.xpath("//li[" + i + "][@class='active']")).getText();
            String temperature = driver.findElement(By.xpath("//*[@class='top-section']/div")).getText();
            System.out.println("Temperature on " + date + " is: " + temperature);
            driver.findElement(By.xpath("//div[@class='scrolling-container-header']/span")).click();
        }

    }


    @Then("^the weather forcast should display for summary of whole day$")
    public void theWeatherForcastShouldDisplayFor() throws Throwable {
        int Count = 5;
        driver.findElement(By.className("stick-footer-panel__link")).click();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        for (i = 1; i <= Count; i++) {
            driver.findElement(By.xpath("//li[" + i + "]/div/span[@class='chevron-container']")).click();
            String date = driver.findElement(By.xpath("//li[" + i + "][@class='active']")).getText();
            String temperature = driver.findElement(By.xpath("//div[@class='daily-detail-container']/table")).getText();
            System.out.println("Temperature for whole day on " + date + " is :\n" + temperature);
            driver.findElement(By.xpath("//div[@class='scrolling-container-header']/span")).click();

        }

    }


    @When("^the user clicks to hide the summary info$")
    public void theUserClicksToHideTheSummaryInfo() {
        driver.findElement(By.xpath("//div[@class='scrolling-container-header']/span")).click();
    }

    @Then("^the weather forcast of whole day is not displayed$")
    public boolean theWeatherForcastOfWholeDayIsNotDisplayed() {
        try {
            driver.findElement(By.className("daily-detail-container"));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }


}
