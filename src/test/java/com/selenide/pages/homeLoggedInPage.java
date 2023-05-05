package com.selenide.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byText;

public class homeLoggedInPage {
    
    public homeLoggedInPage newPost(){
        Selenide.$(byText("New Post")).click();
         return this;
    }    

    public homeLoggedInPage personalUserButton(){
        Selenide.$(byText("Mantonelli")).click();
         return this;
    }  
}
