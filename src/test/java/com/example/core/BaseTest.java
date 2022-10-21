package com.example.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.base.ConfProperties;
import org.example.db.DBUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public static WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(ConfProperties.getProperty("homePage"));
        driver.manage().window().maximize();

        DBUtils.createConnection();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
        DBUtils.destroy();
    }
}
