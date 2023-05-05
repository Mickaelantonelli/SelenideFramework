package com.selenide.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTagName;

public class personalUserPage {
 
    public personalUserPage addArticleToFavorite(String articleTitle){
      Selenide.$(byText(articleTitle)).closest(".article-preview").find(byTagName("button")).click();
      return this;
    }

    public personalUserPage readArticle(String articleTitle){
      Selenide.$(byText( articleTitle)).click();
      return this;
    }
}


