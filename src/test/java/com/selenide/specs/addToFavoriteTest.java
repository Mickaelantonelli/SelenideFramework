package com.selenide.specs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import io.qameta.allure.selenide.AllureSelenide;

import com.selenide.pages.homePage;
import com.selenide.pages.signInPage;

import com.selenide.pages.homeLoggedInPage;
import com.selenide.pages.newPostPage;
import com.selenide.pages.personalUserPage;
import com.selenide.pages.articlePage;

import com.codeborne.selenide.logevents.SelenideLogger;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Condition.text;

public class addToFavoriteTest {

    static homePage home = new homePage();
    static signInPage signIn = new signInPage();
    static homeLoggedInPage homeLoggedIn = new homeLoggedInPage();
    static newPostPage newPost = new newPostPage();
    static articlePage article = new articlePage();
    static personalUserPage personalUser = new personalUserPage();

    static String articleTitle = "Quality Engineer Title";

    @BeforeClass
    public static void setUp(){
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    String articleContext = "This is about a Quality Engineer.";
    String articleContent = "I'm writing an article.";
    String articleTags = "This is a tag.";
    String emailAddress = "mickael.antonelli@gmail.com";
    String password = "Soso75018";

    home.open();
    home.signInBtn();
    signIn.setEmailAddress(emailAddress)
        .setPassword(password)
        .submit();

    homeLoggedIn.newPost();
    newPost.setArticleTitle(articleTitle)
           .setArticleContext(articleContext)
           .setArticleContent(articleContent)
           .setArticleTags(articleTags)
           .publishArticleButton();
    $(byCssSelector("h1")).shouldHave(text(articleTitle));
    $(byCssSelector("div.col-xs-12")).shouldHave(text(articleContent)); 
    }
    
    @Test
    public void userCreateFormFromUserLoggedInPage(){
        homeLoggedIn.personalUserButton();
        $(byText(articleTitle)).closest(".article-preview").find(byClassName("ion-heart"));
        personalUser.addArticleToFavorite(articleTitle);
    }

    @AfterClass
    public static void tearDown(){
    personalUser.readArticle(articleTitle);
    article.deleteArticle();
    $(byClassName("article-preview")).shouldHave(text("No articles are here... yet."));
    $(byAttribute("href", "#settings")).click();
    $(byClassName("btn-outline-danger")).shouldHave(text("Or click here to logout."));
    $(byCssSelector("button.btn.btn-outline-danger")).click();
    $(byAttribute("href", "#login"));
    }
}