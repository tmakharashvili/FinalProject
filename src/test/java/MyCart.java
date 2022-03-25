import Wishlist.StepObject.CartSteps;
import Wishlist.Utils.Retry;
import Wishlist.Utils.Runner;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Wishlist.DataObject.WishListData.Option;
import static com.codeborne.selenide.Selenide.*;

@Listeners(Wishlist.Utils.TestLister.class)
public class MyCart extends Runner {
    @Test (retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Searching item for place order")
    public void myWishList (){
        CartSteps steps = new CartSteps();
        steps
                .gotoCart();
        Assert.assertTrue(steps.CartIsEmpty.isDisplayed());
        steps
                .goToSearch();
      //  Assert.assertEquals(steps.SearchInput.getText(),"Option");
        steps
                .searching()
      //          .sort()
                .chooseItem();
        sleep(5000);
        steps
                .gotoCart()
                .checkCart();
        Assert.assertTrue(steps.CartContent.isDisplayed());
        Assert.assertTrue(steps.PlaceOrderButton.isEnabled());
        steps
                .placeOrder();
    }

    @Test (retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Specifying wishlist")
    public void manageTheCart(){
        CartSteps steps = new CartSteps();
        steps
                .goToSearch();
        Assert.assertFalse(steps.SearchInput.is(Condition.empty));
        steps
                .searching()
                .priceDiapason()
                .selectPrice();
        Assert.assertTrue(steps.SearchResult.isDisplayed());
        steps
                .chooseItem();
        sleep(3000);
        steps
                .gotoCart()
                .checkCart();
        Assert.assertFalse(steps.EmptyTheBasketButton.is(Condition.disabled));
        steps
                .emptyTheBasket();
        Assert.assertTrue(steps.YouCartIsEmpty.isDisplayed());
    }
}
