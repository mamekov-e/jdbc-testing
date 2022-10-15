package com.example.core;

import org.example.base.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public interface SignInInterface {
    default void signIn(String email, String password, WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickOnSignInLink();
        loginPage.signIn(email, password);
    }
}
