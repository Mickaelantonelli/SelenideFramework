package com.selenide.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.*;

public class articlePage {
    
    public articlePage deleteArticle(){
        Selenide.$(byText( "Delete Article")).click();
         return this;
    }    
}
