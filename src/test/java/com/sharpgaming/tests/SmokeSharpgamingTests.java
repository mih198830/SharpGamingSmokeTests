package com.sharpgaming.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class SmokeSharpgamingTests extends TestBase {
    @Test
    @Description("Check that email link exist on the About Us page")
    @DisplayName("Email link test - About us page ")
    void emailLinkTest() {

        step("Click About Us Link", () -> {
            homePage.aboutUsLinkClick();
        });

        step("Check email address is present on the About Us page", () -> {
            aboutUsPage.emailAddress();
        });
    }

    @Test
    @Description("Open What we Do page and click Vacancies button")
    @DisplayName("Open What we Do page and open Vacancies")
    void checkVacanciesFromWhatWePage() {
        step("Click What we do Link", () -> {
            homePage.whatWeDoLinkClick();
        });

        step("Click Vacancies from What we do page", () -> {
            whatWeDoPage.vacanciesButtonClick();
            vacanciesPage.vacanciesBlockCheckIsVisible();
        });
    }

    @Test
    @Description("Open Vacancies page and check vacancies block is available")
    @DisplayName("Vacancies block available for users")
    void vacanciesBlockAvailable() {
        step("Click What we do Link", () -> {
            homePage.whatWeDoLinkClick();
        });

        step("Check vacancies block is visible on the Vacancies page", () -> {
            whatWeDoPage.vacanciesButtonClick();
        });
    }

    @Test
    @Description("No error about mandatory field")
    @DisplayName("No error about mandatory field")
    void contactFormCheck() {
        step("Click Contact Link", () -> {
            homePage.contactUsLinkClick();
        });

        step("Print first name", () -> {
            contactPage.firstNameFormPrint(testData.firstName);
        });

        step("Print last name", () -> {
            contactPage.lastNameFormPrint(testData.lastName);
        });

        step("Print email", () -> {
            contactPage.emailFormPrint(testData.email);
        });

        step("No Error messages on the page", () -> {
            $(".field-error").shouldNotBe(visible);
            ;
        });
    }
}