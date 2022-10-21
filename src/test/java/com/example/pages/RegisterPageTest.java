package com.example.pages;

import com.example.core.BaseTest;
import org.example.base.ConfProperties;
import org.example.base.HomePage;
import org.example.domain.User;
import org.example.db.DBUtils;
import org.example.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {
    private HomePage homePage;
    private RegisterPage registerPage;
    private String email = ConfProperties.getProperty("email");
    private String password = ConfProperties.getProperty("password");
    private String username = ConfProperties.getProperty("username");
    private String insertQuery = "INSERT INTO user (email, username, password)";

    @BeforeClass
    public void initialization(){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void registerTest() {
        homePage.clickOnSignUpLink();
        registerPage.register(email, password, username);

        DBUtils.insertQuery(insertQuery + "values ('" + email + "', '"+ username + "', '" + password + "');");

        User fetchedUser = DBUtils.getUserData("SELECT *from user where username ='" + username + "';");

        Assert.assertEquals(username, fetchedUser.getUsername());
        Assert.assertEquals(email, fetchedUser.getEmail());
        Assert.assertEquals(password, fetchedUser.getPassword());
    }

    @AfterMethod
    public void signOut() {
        homePage.clickOnSignOutLink();
    }
}
