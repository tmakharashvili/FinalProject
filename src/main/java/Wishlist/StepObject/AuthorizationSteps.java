package Wishlist.StepObject;

import Wishlist.PageObject.AuthorizationPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.time.Duration;

public class AuthorizationSteps extends AuthorizationPage {
    @Step ("click myaccount Button")
    public AuthorizationSteps goToMyAccountPage() {
        MyAccountButton.click();
        return this;
    }
    @Step ("Sign in")
    public AuthorizationSteps goToAuthorizationPage() {
        AuthorizationButton.click();
        return this;
    }
    @Step ("appears Authorization text")
    public AuthorizationSteps authorizationText(){
        AuthorizationText.isDisplayed();
        return this;
    }
    @Step ("Login email is - {makharashvili.tamuna.gmail.com}")
    public AuthorizationSteps fillLoginEmail(String EmailValue){
        LoginEmailInput.setValue(EmailValue);
        LoginEmailInput.shouldNotBe(Condition.empty);
        return this;
    }
    @Step ("Wrong email is - {test}")
    public AuthorizationSteps fillLoginInputWithWrongValue (String WrongEmailValue){
        LoginEmailInput.setValue(WrongEmailValue);
        return this;
    }
    @Step ("login password is - {123123}")
    public AuthorizationSteps fillLoginPassword(String PasswordValue){
        LoginPasswordInput.setValue(PasswordValue);
        LoginPasswordInput.shouldNotBe(Condition.empty);
        return this;
    }
    @Step("click rememberMe Button")
    public AuthorizationSteps clickToRememberMe (){
        RememberButton.shouldBe(Condition.visible, Duration.ofMillis(3000)).click();
        return this;
    }
    @Step("click on Authorization Button")
    public AuthorizationSteps goToGettingAuthorizedPage (){
        GetAuthorizedButton.click();
        return this;
    }
}
