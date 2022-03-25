import Wishlist.StepObject.RegistrationSteps;
import Wishlist.Utils.Retry;
import Wishlist.Utils.Runner;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Wishlist.DataObject.RegistrationData.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

@Listeners(Wishlist.Utils.TestLister.class)
public class UserRegistration extends Runner {
    @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.TRIVIAL)
    @Description("fill registration fields with different values")
    public void Registration() {
        RegistrationSteps steps = new RegistrationSteps();
        SoftAssert softAssert = new SoftAssert();
        steps
                .goToMyAccountPage()
                .goToRegistrationPage();
        softAssert.assertTrue(steps.UserIsOnRegistrationPage.isDisplayed());
        softAssert.assertAll();
        steps
                .fillFirstName(FirstNameValue)
                .fillLastName(LastNameValue)
                .fillIdentity(IdentityValue)
                .fillPhone(PhoneValue)
                .fillEmail(EmailValue)
                .fillPassword(PasswordValue)
                .fillPasswordConfirmation(ConfirmationPasswordValue);
        Assert.assertEquals(steps.FirstNameInput.getValue(), FirstNameValue);
        Assert.assertEquals(steps.IdentityInput.getValue(), IdentityValue);
        Assert.assertEquals(steps.PhoneInput.getValue(), PhoneValue);
        Assert.assertEquals(steps.EmailInput.getValue(), EmailValue);
        Assert.assertEquals(steps.PasswordInput.getValue(), PasswordValue);
        Assert.assertEquals(steps.PasswordConfirmationInput.getValue(), ConfirmationPasswordValue);
        Assert.assertTrue(steps.RegisterButton.isEnabled());
        steps
                .gotoRegister();
    }

    @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Check error inputs")
    public void CheckRegistrationFields() {
        RegistrationSteps steps = new RegistrationSteps();
        steps
                .goToMyAccountPage()
                .goToRegistrationPage()
                .fillFirstName(FirstNameValue)
                .fillLastName(LastNameValue)
                .fillIdentity(IdentityValue)
                .fillPhoneInputWithWrongValue(WrongPhoneValue)
                .fillEmailInputWithWrongValue(WrongEmailValue)
                .fillPassword(PasswordValue)
                .fillPasswordConfirmationWithWrongValue(WrongPasswordValue);
        Assert.assertEquals(steps.PasswordConfirmationInput.getValue(), WrongPasswordValue);
        steps
                .gotoRegister()
                .checkErrorInputs();
        Assert.assertTrue(steps.PhoneErrorInput.isDisplayed());
        Assert.assertTrue(steps.EmailErrorInput.isDisplayed());
        Assert.assertTrue(steps.PasswordErrorInput.isDisplayed());
    }
}
