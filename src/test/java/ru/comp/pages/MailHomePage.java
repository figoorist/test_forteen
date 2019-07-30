package ru.comp.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class MailHomePage {

    private SelenideElement newMailButton = $(byXpath("//a[@data-name='compose']"));
    private SelenideElement destinationEmailInput = $(byXpath("//textarea[@data-original-name='To']"));
    private SelenideElement emailSubjectInput = $(byXpath("//input[@name='Subject']"));
    private SelenideElement mailToolFrame = $(byXpath("//iframe[contains(@name, 'toolkit')]"));
    private SelenideElement mailBodyTextarea = $(byXpath("//body"));
    private SelenideElement sendMailButton = $(byXpath("//div[@data-name='send']"));
    private SelenideElement goToInputMailLink = $(byXpath("//a[contains(text(), 'Перейти во Входящие')]"));


    public void sendMail(String destinationEmail, String body) {
        newMailButton.click();
        destinationEmailInput.sendKeys(destinationEmail);
        switchTo().frame(mailToolFrame);
        mailBodyTextarea.sendKeys(body);
        switchTo().parentFrame();
        sendMailButton.click();
        goToInputMailLink.shouldBe(Condition.visible);
    }
}
