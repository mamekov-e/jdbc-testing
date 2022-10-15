package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;

    private WebDriverWait wait;

    public RegisterPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "BirthDay")
    private WebElement daysSelect;

    @FindBy(id = "BirthMonth")
    private WebElement monthsSelect;

    @FindBy(id = "BirthYear")
    private WebElement yearsSelect;

    @FindBy(id = "register")
    private WebElement registerBtn;

    public void register(
            String email,
            String firstName,
            String lastName,
            String password,
            int day,
            int month,
            int year
    ) {
        typeEmail(email);
        typeFirstName(firstName);
        typeLastName(lastName);
        typePassword(password);
        selectBirthdayDay(day);
        selectBirthdayMonth(month);
        selectBirthdayYear(year);
        registerBtn.click();
    }

    private RegisterPage typeEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    private RegisterPage typeFirstName(String firstName){
        firstNameField.sendKeys(firstName);
        return this;
    }

    private RegisterPage typeLastName(String lastName){
        lastNameField.sendKeys(lastName);
        return this;
    }

    private RegisterPage typePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    private RegisterPage selectBirthdayDay(int day){
        Select select = new Select(daysSelect);
        select.selectByValue(Integer.toString(day));
        return this;
    }

    private RegisterPage selectBirthdayMonth(int month){
        Select select = new Select(monthsSelect);
        select.selectByIndex(month);
        return this;
    }

    private RegisterPage selectBirthdayYear(int year){
        Select select = new Select(yearsSelect);
        select.selectByValue(Integer.toString(year));
        return this;
    }
}
