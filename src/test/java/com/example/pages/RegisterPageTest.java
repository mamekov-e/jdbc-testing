package com.example.pages;

import com.example.core.BaseTest;
import com.example.core.SignInInterface;
import org.example.base.ConfProperties;
import org.example.base.HomePage;
import org.example.pages.RegisterPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegisterPageTest extends BaseTest {
    private HomePage homePage;
    private RegisterPage registerPage;

    @BeforeClass
    public void initialization(){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void registerTest() {
        String email = ConfProperties.getProperty("email");
        String password = ConfProperties.getProperty("password");
        String firstName = ConfProperties.getProperty("firstName");
        String lastName = ConfProperties.getProperty("lastName");
        int dayOfBirth = Integer.parseInt(ConfProperties.getProperty("dayOfBirth"));
        int monthOfBirth = Integer.parseInt(ConfProperties.getProperty("monthOfBirth"));
        int yearOfBirth = Integer.parseInt(ConfProperties.getProperty("yearOfBirth"));

        homePage.clickOnSignUpLink();
        registerPage.register(email, firstName, lastName, password, dayOfBirth, monthOfBirth, yearOfBirth);
    }
}
