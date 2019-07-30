package ru.comp.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.comp.pages.HomePage;
import ru.comp.pages.MailHomePage;

public class MailTestClass {

    private HomePage homePage;
    private MailHomePage inputMailPage;

    @BeforeClass
    @Parameters({"siteUrl", "login", "password"})
    public void initPageObjects(String siteUrl, String login, String password) {
        homePage = new HomePage(siteUrl);
        inputMailPage = new MailHomePage();
        homePage.goToHomePage();
        homePage.login(login, password);
    }

    @Test
    @Parameters({"destination", "body" })
    public void testSendMail(String destination, String body) {
        inputMailPage.SendMail(destination, body);
    }
}
