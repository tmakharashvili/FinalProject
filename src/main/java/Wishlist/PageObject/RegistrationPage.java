package Wishlist.PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    public SelenideElement
        MyAccountButton = $("#sw_dropdown_268"),
        RegistrationButton = $(byText("რეგისტრაცია")),
        FirstNameInput = $("#elm_6"),
        LastNameInput = $("#elm_7"),
        IdentityInput = $("#elm_36"),
        PhoneInput = $("#elm_9"),
        PhoneErrorInput = $("#elm_9_error_message"),
        EmailInput = $(byName("user_data[email]")),
        EmailErrorInput = $("#email_error_message"),
        PasswordInput = $(byName("user_data[password1]")),
        PasswordConfirmationInput = $(byName("user_data[password2]")),
        PasswordErrorInput = $("#password2_error_message"),
        RegisterButton = $(byName("dispatch[profiles.update]")),
        UserIsOnRegistrationPage = $(".ty-mainbox-title");
}
