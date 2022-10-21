package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(id = "name")
    private WebElement usernameField;

    @FindBy(name = "password1")
    private WebElement passwordField;

    @FindBy(name = "password2")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//span[text()='Отправить']")
    private WebElement registerBtn;

    public void register(
            String email,
            String password,
            String username
    ) {
        typeEmail(email);
        typePassword(password);
        typeConfirmPassword(password);
        typeUsername(username);
        registerBtn.click();

        submit();
    }

    private void submit(){
        wait.until(ExpectedConditions.visibilityOf(registerBtn));
        registerBtn.click();
    }

    private RegisterPage typeEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    private RegisterPage typePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    private RegisterPage typeConfirmPassword(String password){
        confirmPasswordField.sendKeys(password);
        return this;
    }

    private RegisterPage typeUsername(String username){
        usernameField.sendKeys(username);
        return this;
    }
}
