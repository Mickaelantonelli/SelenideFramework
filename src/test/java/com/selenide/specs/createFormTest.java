package com.selenide.specs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.selenide.pages.homePage;
import com.selenide.pages.signInPage;
import com.selenide.pages.homeLoggedInPage;
import com.selenide.pages.newPostPage;
import com.selenide.pages.articlePage;
import com.selenide.pages.personalUserPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;

public class createFormTest {

    static homePage home = new homePage();
    static signInPage signIn = new signInPage();
    static homeLoggedInPage homeLoggedIn = new homeLoggedInPage();
    static newPostPage newPost = new newPostPage();
    static articlePage article = new articlePage();
    static personalUserPage personalUser = new personalUserPage();

    static String articleTitle = "QA Engineer Title";


    @BeforeClass
    public static void setUp(){

    String emailAddress = "mickael.antonelli@gmail.com";
    String password = "Soman21react=";

    home.open();
    home.signInBtn();
    signIn.setEmailAddress(emailAddress)
          .setPassword(password)
          .submit();
    }
    
    @Test
    public void userCreateFormFromUserLoggedInPage(){ 

        String articleContext = "This is about a QA Engineer position.";
        String articleContent = "I'm writing an article.";
        String articleTags = "This is a tag.";

        homeLoggedIn.newPost();
        newPost.setArticleTitle(articleTitle)
               .setArticleContext(articleContext)
               .setArticleContent(articleContent)
               .setArticleTags(articleTags)
               .publishArticleButton();
               
        $(byCssSelector("h1")).shouldHave(text(articleTitle));
        $(byCssSelector("div.col-xs-12")).shouldHave(text(articleContent));    
    }

    @AfterClass
    public static void tearDown(){
        homeLoggedIn.personalUserButton();
        personalUser.readArticle(articleTitle);
        article.deleteArticle();
        $(byClassName("article-preview")).shouldHave(text("No articles are here... yet."));
        $(byAttribute("href", "#settings")).click();
        $(byClassName("btn-outline-danger")).shouldHave(text("Or click here to logout."));
        $(byClassName("btn-outline-danger")).click();
        $(byAttribute("href", "#login"));
    }
}