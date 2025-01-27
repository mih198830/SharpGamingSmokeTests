package com.sharpgaming.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.sharpgaming.config.Project;
import com.sharpgaming.helpers.AllureAttachments;
import com.sharpgaming.helpers.DriverSettings;
import com.sharpgaming.helpers.DriverUtils;
import com.sharpgaming.tests.pages.*;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith({AllureJunit5.class})
public class TestBase {
    TestData testData = new TestData();
    HomePage homePage = new HomePage();
    AboutUsPage aboutUsPage = new AboutUsPage();
    WhatWeDoPage whatWeDoPage = new WhatWeDoPage();
    VacanciesPage vacanciesPage = new VacanciesPage();
    ContactPage contactPage = new ContactPage();

    @BeforeAll
    static void beforeAll() {
        DriverSettings.configure();
    }


    @BeforeEach
    public void openPage() {
        Selenide.open("https://www.sharpgaming.com/");
    }

    public void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void afterEach() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        AllureAttachments.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}
