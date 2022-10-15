package com.example.pages;

import com.example.core.BaseTest;
import com.example.core.SignInInterface;
import org.example.base.ConfProperties;
import org.example.base.HomePage;
import org.example.db.DBUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LoginPageTest extends BaseTest implements SignInInterface {
    private HomePage homePage;

    @BeforeClass
    public void initialization(){
        //initialization of HomePage.java
        homePage = new HomePage(driver);
    }

    @Test
    public void signInTest() {
        String email = ConfProperties.getProperty("email");
        String password = ConfProperties.getProperty("password");
        signIn(email, password, driver);

        //get current logged time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        dtf.format(now);

    }
}
