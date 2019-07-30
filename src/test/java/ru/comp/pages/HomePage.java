package ru.comp.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    private String url;

    private SelenideElement loginForm = $("#auth");
    private SelenideElement txtLoginInput = $(byXpath("//form[@id='auth']//*[@name='login']"));
    private SelenideElement txtPasswordInput = $(byXpath("//form[@id='auth']//*[@name='password']"));
    private SelenideElement submitLoginButton = $(byXpath("//form[@id='auth']//*[@type='submit']"));

    public HomePage(String url) {
        this.url = url;
    }

    public void goToHomePage() {
        open(url);
        loginForm.shouldBe(Condition.visible);
    }

    public void login(String login, String password) {
        txtLoginInput.sendKeys(login);
        txtPasswordInput.sendKeys(password);
        submitLoginButton.click();
    }
}
