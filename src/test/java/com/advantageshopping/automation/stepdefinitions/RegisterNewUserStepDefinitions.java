package com.advantageshopping.automation.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

import java.time.Clock;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterNewUserStepDefinitions {

    public WebDriver driver;

    String user= "DaniloFernandez";
    String password = "Danilo05";
    String usernam;


    @Given("^that a web user wants to register in advantage shopping online$")
    public void thatAWebUserWantsToRegisterInAdvantageShoppingOnline() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.advantageonlineshopping.com/#/register");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @When("^he fills all the requested fields$")
    public void heFillsAllTheRequestedFields() {
        assertEquals(driver.findElement(By.xpath("//h3[text()='CREATE ACCOUNT']")).getText(),"CREATE ACCOUNT");
        driver.findElement(By.name("usernameRegisterPage")).sendKeys(""+ user);
        driver.findElement(By.name("emailRegisterPage")).sendKeys("danilofdezh@gmail.com");
        driver.findElement(By.name("passwordRegisterPage")).sendKeys(""+password);
        driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys(""+password);
        driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Danilo");
        driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Antonio");
        driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("3013463038");
        driver.findElement(By.name("countryListboxRegisterPage")).sendKeys("Colombia");
        driver.findElement(By.name("cityRegisterPage")).sendKeys("Cerete");
        driver.findElement(By.name("addressRegisterPage")).sendKeys("La granja");
        driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("Monteria");
        driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("0101");
        driver.findElement(By.name("i_agree")).click();
        driver.findElement(By.id("register_btnundefined")).click();


    }
    @Then("^he should see him username in the homepage$")
    public void heShouldSeeHimUsernameInTheHomepage() {
        driver.get("https://www.advantageonlineshopping.com/#/");

        WebDriverWait wait= new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menuUserLink")));
        driver.findElement(By.id("menuUserLink")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='username']")));
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys(  ""+user);
        driver.findElement(By.name("password")).sendKeys( ""+password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='sing_in_btnundefined']")));
        driver.manage().timeouts().implicitlyWait( 100, TimeUnit.SECONDS);
        driver.findElement(By.id("sing_in_btnundefined")).click();

        usernam=driver.findElement(By.xpath("//*[@class='hi-user containMiniTitle ng-binding']")).getText();
        Assert.assertEquals(usernam, user);

    }

}