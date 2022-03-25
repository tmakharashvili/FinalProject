package Wishlist.PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    public SelenideElement
            SearchInput = $(byName("hint_q")),
            SearchButton = $(".ty-search-magnifier"),
            SortButton = $("#sw_elm_sort_fields"),
            PopularityOption = $(".sort-by-popularity-desc"),
            PriceButton = $("#sw_elm_filter_2"),
            RangePrice = $(byXpath("//*[@id=\"slider_95_2\"]/span[2]")),
            SearchResult = $("#products_search_total_found_11"),
            ChooseItemButton = $("#button_cart_64350"),
            CartButton = $("#sw_dropdown_267"),
            CheckCartButton = $(byXpath("//*[@id=\"dropdown_267\"]/div/div[2]/div[1]/a")),
            CartIsEmpty = $(".ty-cart-items__empty"),
            CartContent = $(".ty-mainbox-title"),
            PlaceOrderButton = $(".ty-cart-content__right-buttons"),
            EmptyTheBasketButton = $(byText("კალათის დაცლა")),
            YouCartIsEmpty = $(byText("თქვენი კალათა ცარიელია"));

}
