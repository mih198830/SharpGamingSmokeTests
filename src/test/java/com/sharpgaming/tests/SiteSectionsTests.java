package com.sharpgaming.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class SiteSectionsTests extends TestBase {
    @Test
    @DisplayName("Check that email link exist on the About Us page")
    void emailLinkTest() {

        step("Click About Us Link", () ->
            homePage.aboutUsLinkClick()
        );

        step("Check email address is present on the About Us page", () ->
            aboutUsPage.emailAddress()
        );
    }

    @Test
    @DisplayName("Open What we Do page and open Vacancies")
    void checkVacanciesFromWhatWePage() {
        step("Click What we do Link", () ->
            homePage.whatWeDoLinkClick()
        );

        step("Click Vacancies from What we do page", () -> {
            whatWeDoPage.vacanciesButtonClick();
            vacanciesPage.vacanciesBlockCheckIsVisible();
        });
    }

    @Test
    @DisplayName("Vacancies block available for users")
    void vacanciesBlockAvailable() {
        step("Click What we do Link", () ->
            homePage.whatWeDoLinkClick()
        );

        step("Check vacancies block is visible on the Vacancies page", () ->
            whatWeDoPage.vacanciesButtonClick()
        );
    }

    @Test
    @DisplayName("No error appears about mandatory field")
    void contactFormCheck() {
        step("Click Contact Link", () ->
                homePage.contactUsLinkClick()
        );

        step("Print first name", () ->
                contactPage.firstNameFormPrint(testData.firstName)
        );

        step("Print last name", () ->
                contactPage.lastNameFormPrint(testData.lastName)
        );

        step("Print email", () ->
                contactPage.emailFormPrint(testData.email)
        );

        step("No Error messages on the page", () ->
                $(".field-error").shouldNotBe(visible)
        );
    }
}
