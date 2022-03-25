package Wishlist.StepObject;

import Wishlist.PageObject.CartPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.time.Duration;

import static Wishlist.DataObject.WishListData.Option;
import static com.codeborne.selenide.Selenide.$;

public class CartSteps extends CartPage {
    @Step("search item")
    public CartSteps goToSearch (){
        SearchInput.setValue(Option);
        return this;
    }
    @Step("click on search button")
    public CartSteps searching () {
        SearchButton.pressEnter();
        return this;
    }
    @Step("click on price button")
    public CartSteps priceDiapason(){
        PriceButton.click();
        return this;
    }
    @Step("Specify price")
    public CartSteps selectPrice(){
        RangePrice.click();
        SearchResult.shouldBe(Condition.visible, Duration.ofMillis(1000));
        return this;
    }
    @Step("Sort items")
    public CartSteps sort (){
        SortButton.selectOption("პოპულარობით");
        return this;
    }
    @Step("Choose item")
    public CartSteps chooseItem () {
        ChooseItemButton. pressEnter();
        return this;
    }
    @Step("Click on Cart Button")
    public CartSteps gotoCart () {
        CartButton.click();
        return this;
    }
    @Step("view Cart")
    public CartSteps checkCart () {
        CheckCartButton.click();
        return this;
    }
    @Step("Go to buy")
    public CartSteps placeOrder(){
        PlaceOrderButton.click();
        return this;
    }
    @Step("Empty the Basket")
    public CartSteps emptyTheBasket(){
        EmptyTheBasketButton.click();
        YouCartIsEmpty.shouldBe(Condition.visible,Duration.ofMillis(1000));
        return this;
    }
}
