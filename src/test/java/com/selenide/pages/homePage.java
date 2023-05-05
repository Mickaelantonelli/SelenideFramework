package com.selenide.pages;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byText;

public class homePage {
    
    public homePage open(){
        Selenide.open("https://react-redux.realworld.io/");
         return this;
    }    

    public homePage signInBtn(){
       Selenide.$(byText("Sign in")).click();
       return this;
    }
}
