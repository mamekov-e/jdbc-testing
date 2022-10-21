package org.example.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    private WebDriverWait wait;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @FindBy(linkText = "Регистрация")
    private WebElement signUpLink;

    @FindBy(linkText = "Выход")
    private WebElement signOutLink;

    public void clickOnSignUpLink(){
        wait.until(ExpectedConditions.visibilityOf(signUpLink));
        signUpLink.click();
    }

    public void clickOnSignOutLink(){
        wait.until(ExpectedConditions.visibilityOf(signOutLink));
        signOutLink.click();
    }
}
