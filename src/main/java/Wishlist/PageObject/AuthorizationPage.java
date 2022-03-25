package Wishlist.PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage {
    public SelenideElement
    MyAccountButton = $("#sw_dropdown_268"),
    AuthorizationButton = $(byXpath("//*[@id=\"account_info_268\"]/div[2]/a[1]")),
    AuthorizationText = $("#ui-id-1"),
    RememberButton = $(".checkbox"),
    GetAuthorizedButton = $(byName("dispatch[auth.login]")),
    LoginEmailInput = $("#login_popup268"),
    LoginErrorInput = $(".help-inline"),
    LoginPasswordInput = $("#psw_popup268"),
    ForgotPasswordButton = $(".ty-password-forgot__a");
}
