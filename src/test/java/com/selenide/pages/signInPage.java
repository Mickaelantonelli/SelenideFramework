package com.selenide.pages;
import com.codeborne.selenide.Selenide;

public class signInPage {
 
    public signInPage setEmailAddress(String email){
      Selenide.$("[placeholder=Email]").setValue(email);
      return this;
    }

    public signInPage setPassword(String password){
      Selenide.$("[placeholder=Password]").setValue(password);
      return this;
   }

   public signInPage submit(){
      Selenide.$("[type=Submit]").click();
      return this;
   }
}
