package com.selenide.specs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.selenide.pages.homePage;
import com.selenide.pages.signInPage;


import io.qameta.allure.selenide.AllureSelenide;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.selenide.pages.homeLoggedInPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;

public class userLoginTest {

    static homePage home = new homePage();
    static signInPage signIn = new signInPage();
    static homeLoggedInPage homeLoggedIn = new homeLoggedInPage();

    @BeforeClass
    public static void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        home.open()
            .signInBtn();
    }
    
    @Test
    public void userCanLoginByUsername(){
        String emailAddress = "mickael.antonelli@gmail.com";
        String password = "Soman21react=";
        String userName = "Mantonelli";

        signIn.setEmailAddress(emailAddress)
              .setPassword(password)
              .submit();

        $(byAttribute("href", "#@" + userName)).shouldBe(visible);
        homeLoggedIn.personalUserButton();
        $(byCssSelector("h4")).shouldHave(text(userName));
    }

    @AfterClass
    public static void tearDown(){
        $(byAttribute("href", "#settings")).click();
        $(byClassName("btn-outline-danger")).shouldHave(text("Or click here to logout."));
        $(byClassName("btn-outline-danger")).click();
        $(byAttribute("href", "#login"));
    }
}
