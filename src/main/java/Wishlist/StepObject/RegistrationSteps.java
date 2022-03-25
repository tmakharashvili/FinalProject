package Wishlist.StepObject;

import Wishlist.PageObject.RegistrationPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.time.Duration;

import static Wishlist.DataObject.RegistrationData.WrongPasswordValue;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationSteps extends RegistrationPage {
    @Step("click myaccount Button")
    public RegistrationSteps goToMyAccountPage() {
        MyAccountButton.click();
        return this;
    }
    @Step("get registered")
    public RegistrationSteps goToRegistrationPage() {
        RegistrationButton.click();
        UserIsOnRegistrationPage.shouldBe(Condition.visible, Duration.ofMillis(2000));
        return this;
    }
    @Step ("Firstname is - {Tamar}")
    public RegistrationSteps fillFirstName(String FirstNameValue) {
        FirstNameInput.setValue(FirstNameValue);
        FirstNameInput.shouldNotBe(Condition.empty, Duration.ofMillis(1000));
        return this;
    }
    @Step ("Lastname is - {Makharashvili}")
    public RegistrationSteps fillLastName(String LastNameValue) {
        LastNameInput.setValue(LastNameValue);
        LastNameInput.shouldNotBe(Condition.empty, Duration.ofMillis(1000));
        return this;
    }
    @Step ("Identity is - {01019041190}")
    public RegistrationSteps fillIdentity(String IdentityValue) {
        IdentityInput.setValue(IdentityValue);
        IdentityInput.shouldNotBe(Condition.empty, Duration.ofMillis(1000));
        return this;
    }
    @Step ("Phone number is - {595730009}")
    public RegistrationSteps fillPhone(String PhoneValue) {
        PhoneInput.setValue(PhoneValue);
        PhoneInput.shouldNotBe(Condition.empty, Duration.ofMillis(1000));
        return this;
    }
    @Step ("E-mail is - {Makharashvili.tamuna@gmail.com}")
    public RegistrationSteps fillEmail(String EmailValue) {
        EmailInput.setValue(EmailValue);
        EmailInput.shouldNotBe(Condition.empty, Duration.ofMillis(1000));
        return this;
    }
    @Step ("Password is - {123123}")
    public RegistrationSteps fillPassword(String PasswordValue) {
        PasswordInput.setValue(PasswordValue);
        PasswordInput.shouldNotBe(Condition.empty, Duration.ofMillis(1000));
        return this;
    }
    @Step ("Password is - {123123}")
    public RegistrationSteps fillPasswordConfirmation(String PasswordValue) {
        PasswordConfirmationInput.setValue(PasswordValue);
        PasswordConfirmationInput.shouldNotBe(Condition.empty, Duration.ofMillis(1000));
        return this;
    }
    @Step("click on Registration")
    public RegistrationSteps gotoRegister() {
        RegisterButton.click();
        return this;
    }
    @Step("Wrong phone number is - {55555}")
    public RegistrationSteps fillPhoneInputWithWrongValue(String WrongPHoneValue) {
        PhoneInput.setValue(WrongPHoneValue);
        return this;
    }
    @Step("Wrong email is - {test}")
    public RegistrationSteps fillEmailInputWithWrongValue(String WrongEmailValue) {
        EmailInput.setValue(WrongEmailValue);
        return this;
    }
    @Step("Wrong password is - {123}")
    public RegistrationSteps fillPasswordConfirmationWithWrongValue(String WrongPasswordValue) {
        PasswordConfirmationInput.setValue(WrongPasswordValue);
        return this;
    }
    @Step("Check errors")
    public RegistrationSteps checkErrorInputs(){
        PhoneErrorInput.shouldBe(Condition.visible, Duration.ofMillis(1000));
        EmailErrorInput.shouldBe(Condition.visible, Duration.ofMillis(1000));
        PasswordErrorInput.shouldBe(Condition.visible, Duration.ofMillis(1000));
        return this;
    }
}