import Wishlist.StepObject.AuthorizationSteps;
import Wishlist.Utils.Retry;
import Wishlist.Utils.Runner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Wishlist.DataObject.RegistrationData.*;

@Listeners(Wishlist.Utils.TestLister.class)
public class Login extends Runner {
    @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description ("fill login fields with different values")
    public void authorization() {
        AuthorizationSteps steps = new AuthorizationSteps();
        steps
                .goToMyAccountPage()
                .goToAuthorizationPage();
        Assert.assertTrue(steps.AuthorizationText.isDisplayed());
        steps
                .fillLoginEmail(EmailValue)
                .fillLoginPassword(PasswordValue);
        Assert.assertEquals(steps.LoginEmailInput.getValue(), EmailValue);
        Assert.assertEquals(steps.LoginPasswordInput.getValue(), PasswordValue);
        steps
                .clickToRememberMe();
        Assert.assertTrue(steps.RememberButton.isSelected());
        Assert.assertTrue(steps.GetAuthorizedButton.isEnabled());
        steps
                .goToGettingAuthorizedPage();
    }

    @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.NORMAL)
    @Description("check error inputs and buttons")
    public void authorizationfields (){
        AuthorizationSteps steps = new AuthorizationSteps();
        steps
                .goToMyAccountPage()
                .goToAuthorizationPage()
                .fillLoginInputWithWrongValue (WrongEmailValue)
                .fillLoginPassword(PasswordValue);
        Assert.assertEquals(steps.LoginEmailInput.getValue(), WrongEmailValue);
        Assert.assertEquals(steps.LoginPasswordInput.getValue(), PasswordValue);
        Assert.assertTrue(steps.ForgotPasswordButton.isEnabled());
        steps
                .goToGettingAuthorizedPage();
        Assert.assertTrue(steps.LoginErrorInput.isDisplayed());
    }
}

