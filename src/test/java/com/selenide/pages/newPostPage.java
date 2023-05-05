package com.selenide.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.*;

public class newPostPage {
 
    public newPostPage setArticleTitle(String articleTitle){
      Selenide.$("input[placeholder='Article Title']").setValue(articleTitle);
      return this;
    }

    public newPostPage setArticleContext(String articleContext){
        Selenide.$(by("placeholder", "What's this article about?")).setValue(articleContext);
        return this;
      }

    public newPostPage setArticleContent(String articleContent){
        Selenide.$(by("placeholder", "Write your article (in markdown)")).setValue(articleContent);
        return this;
    }

    public newPostPage setArticleTags(String articleTags){
        Selenide.$(by("placeholder", "Enter tags")).setValue(articleTags);
        return this;
    }

    public newPostPage publishArticleButton(){
        Selenide.$(byText("Publish Article")).click();
        return this;
    }
   }

